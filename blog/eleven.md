---
date: 2023-04-07
title: "How we build BI dashboard for our client?"
slug: "bi-dashboard"
author: "Laurence Chen"
---

## OUTCOME

A few years ago, we got asked by Eleven to help them build out the Business Intelligence component of their product. At that time, Eleven were building an accounting platform using Clojure and Datomic, and saw value in Metabase.

We have been working with them ever since, bridging the gap between Datomic and Metabase, and creating a system for generating and embedding custom dashboards. 

## TECH

Clojure, Datomic, Metabase, Plenish, Embedkit

### Requirements

If we want to use Metabase as the Business Intelligence interface in Eleven's product, we need to provide the glue software, which connects the Eleven's product to Metabase. There are several challenges in front of the glue software.

1. It needs to make the data available to Metabase. 
2. Easy to maintain.
3. Performant enough.
4. It needs to provide suitable access controll to the data. That is, the Metabase access control should be naturally apply to the user data boundary in Eleven's product. 


### The long jounery

Metabase is a powerful dashboard: beautiful UI and can easily connect to many RDMBS databases. However, Eleven's data lives in Datomic, yet Metabase does not support datalog. 

We first developed a custom [Metabase driver](https://github.com/lambdaisland/metabase-datomic) to talk to datomic. This worked reasonably well, but was costly to maintain, mainly because Metabase has very little regard for keeping compatibility towards third party driver vendors.

In 2019 the Datomic team came out with a Datomic driver for Presto, which is bundled with Datomic pro, and thus allows SQL access to Datomic’s triple-store data. Given that we could rely on the Datomic team to maintain this, it was a no-brainer to switch to that, however this has not been a great experience.

- The Presto driver is rapidly going out of date. Presto has forked into PrestoSQL and Trino, with Trino having the most traction, but there is no Trino version of Datomic-Analytics in sight.This in turn is blocking us from upgrading Metabase, which has dropped support for Presto in favor of Trino.
- Datomic-analytics connects via a peer server, this means additional operation overhead since we now need to run both a peer server and Presto.
- Running peer servers can’t pick up new databases, so when adding new database in Datomic, we have to schedule a peer server restart.
- Performance has been underwhelming, with dashboards for large datasets becoming unacceptably slow, and with very little affordances to influence that, besides throwing more CPU and RAM at the problem.
- Resource usage between the peer server, Presto, and Metabase, is very high, eclipsing the resource usage of the rest of the application.
- There is a desire to integrate with other data sources at the SQL layer, which Presto in theory is a good fit for, but the Metabase driver for Presto only allows accessing a single “catalog” at once, at least when using the Metabase query builder.
- On the other hand Presto has access to all datomic databases that the peer server has access to, with no finer grained access control, meaning we can’t provide people with raw SQL access, and need to rely on the somewhat thin assurances of Metabase’s query builder to ensure no unauthorized data access.

### Our solution

With all the above hard-won lessons, this led to a third approach, where we use a similar mapping to relational tables as Datomic Analytics does, but instead of having “virtual tables” backed by Datomic, we actually copy the data into a relational database. Our choice of database has been PostgreSQL, because it’s a fantastic all-around relational database that is well supported and well understood. To this end we started a new Lambda Island project (to be open sourced), called Plenish. 

Plenish synchronizes Datomic to a RDBMS in the real time by reading the Datomic transaction log and converts every event to correponding SQL command. With this simple but not easy idea, Plenish satisifies all the four important requirements elegantly:

- Data is easily available to Metabase because they are copied to a PostgreSQL database.
- The primary software interface Plenish depends is Datomic transaction log, which is very stable.
- PostgreSQL is performant enough for many OLAP use cases.
- Each database in Datomic is synchronized to a corresponding PostgreSQL database, which makes the access controll naturally suit to Metabase's assumptions.