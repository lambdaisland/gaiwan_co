When you buy an electric appliance today you can safely assume it will have a
plug that will fit the wall socket at home, and that it will match the provided
voltage and type of current. There are a number of standard socket types for
lamps, and USB is the ubiquitous connector for low-voltage uses.

Sure, there are regional differences, and still far too many propriatary
connectors. Raise your hand if you have a box of cables somewhere, all
different, half of which you're not quite sure anymore what they connect to. But
in a century and a half the electrical industry has matured tremendously. In
part by market pressure and in part by government mandate things have gotten
reasonably standardized, and there's a great deal of interoperability. Just
think of all the places you can find a headphone jack.

The IT industry in comparison is still in its infancy. Ad-hoc data formats
abound, every API is its own snowflake, with different ways of doing
authentication, pagination, and data representation. That's assuming there is an
API that you can access.

Unfortunately market pressures have so far pushed us in the direction of data
silos. While there can be value in opening data up, and allowing third parties
to synergize with your platform, the opposite is often seen as having greater
value. Locking people into closed platforms, limiting interoperability, and
seeking rent. We have seen many examples of companies willfully crippling a
third party ecosystem that they had originally allowed to spring up, Twitter and
Reddit being some of the most high-profile ones.

But there are signs that the tide is turning. For the last fifteen years we've
seen a lot of VC backed startups creating consumer software in the form of web
and mobile apps. There's been a lot of focus on smooth and attractive UI, in
being the most attractive offering in a given segment. Much of this was
effectively subsidized by large capital investors playing bets on who had the
potential to make it big and drown out the market. Mundane concerns like being
profitable forever postponed by funding round after funding round.

We're now reaching the late stage of this era. Rising interest rates means
funding isn't nearly as easy to find, and platforms that have reached sufficient
dominance are starting to use their position to squeeze users and extract
profits. The Great
[Enshittification](https://pluralistic.net/2023/01/21/potemkin-ai/#hey-guys) has
begun.

There's a rising conciousness that if you're not paying for something, you are
the product, and of the risks of having corporations be the stewards of your
data and online presence. Horror stories like people being locked out of their
Google account indefinitely, obliterating their digital life and online
identity, are tales of caution.

But on top of all that there's something else we lost since the turn of the
century: general purpose computing. Rather than being a bicycle of the mind,
computers are now predominantly consumptions devices. We now do much of our
computing on our phones, where each app is a little island, carefully adjusted
and AB tested to maximize our "engagement". Creation is encouraged if it helps
to increase the engagement of others.

So what do I mean by general purpose computing? Take images. Whether you
encounter them online, or take them with your phone's camera, you can generally
download them to your device, apply edits, crop and slice, combine them with
other images, and introduce them into a different context, like another app or
website.

Imagine being able to do that with information in general. A calendar of events
in your local area, price information from the supermarket, traffic conditions
on your way to work, your recent social media interactions, weather information,
the historical yield of the solar panels on your roof, properties for rent
within your price range. 

This is all information you can find, one way or another. You can see it in
an app on your phone, or in a web browser. What you generally can't do is
download it to your device, filter, slice, dice, combine with other information,
visualize in a way that is most useful to you, and share the result with others.

There are three reasons why. The first and most obvious is that corporations
don't want you to. Controlling and locking in data is the best way they have
right now to bind you to themselves. It makes it costly to switch to a
competitor. Once in that position the value they need to offer to you to
convince you to stay is minimal. Enshittification ensues.

The second reason is lack of general purpose tooling. There are still people who
do general purpose computing, namely professional programmers. There is an
embarassment of riches for experts wanting to create production-grade software.
Some programming language communities do a better job than others at being
accessible to the lay person, but even then it's a steep climb, with many
hurdles along the way that have nothing to do with the task the casual
programmer is trying to accomplish.

We need much more accessible tools, some combination of graphical programming,
textual programming, spreadsheet-like interfaces, and WYSIWIG UI builders. Tools
that "just work" without having to learn about virtual environments, build
systems, and resolving build conflicts. Tools that care about reliability and
stability, that don't break when a second tier dependency puts out a dot
release.

But for such a tool to be able to deliver its promise, we need standardized data
formats and access patterns. And with that we've come to the third reason, as
well as looping back to where we started.

You could say that de facto there are data standards. Virtually every API in the
world speaks JSON, and services that do give end users access to their own data
generally do so as CSV. But these kind of formats only offers the most basic
data model. Key-value dictionaries and lists in the case of JSON, rows and
columns in the case of CSV. This means tools can't do anything interesting with
them without additional information about the semantics of the data.

```json
{"id": "....",
 "name": "....",
 "date": "....",
 "items": [....]}
```

Say you have a JSON blob like this one. What does the `"name"` field mean? Is it
a person's name? The name of a country, a company, some internally generated
name for an entity?

Besides not saying anything about the meaning of `"name"` (or `"date"`, or
`"items"`), this also doesn't say anything about the subject. Who or what is
this data about? We have a bag of properties, and no idea where to assign them
to. There's an `"id"` field, so maybe we can assume that gives us a stable
identifier for whatever the rest of these properties are about. But in any case
it's a lot of guesswork.

The best solution we have for these issues is RDF. RDF stands for Resource
Description Framework, and is a child of the Semantic Web movement. Semantic Web
was a buzzword in the early nillies, but the idea didn't get quite the traction
its proponents had hoped for. There are a number of reasons for that, which I
don't want to rehash now. What matters for us is that RDF (and a number of
adjacent technologies and standards) is still around today, that there's a large
existing ecosystem with libraries available in all common languages, and that if
you cut through the academic babble it is an emminently practical way of
representing and working with data.

RDF is still actively used in the industry, and is part of what powers the
Fediverse (Mastodon and friends), as well as Tim Berners-Lee's Solid project.

RDF made two important choices: represent the world as triples, and use URIs as
identifiers.

The fundamental unit of information in RDF is the triple, representing a
Subject, Predicate, and Object (or Entity, Attribute, Value if you will). For
example, somewhat informally I could present the following triples to describe
Gaiwan:

```
(Gaiwan, has_type, Consultancy)
(Gaiwan, specializes_in, Clojure)
(Gaiwan, specializes_in, Data Solutions)
(Clojure, has_type, Programming Language)
(Consultancy, subtype_of, Company)
```

Triples form a great unit of knowledge. With key-value pairs you are missing a
Subject. What are we talking about? Triples are self-contained and minimal, but
rich enough in aggregate to convey complex information. You may notice that
"Clojure" and "Consultancy" appear both as Subject and Object. This shows how
together these statements start to represent a graph of knowledge.

Note that the representation above is not what serialized RDF really looks like.
RDF has multiple serialization formats. The main ones to know about are Turtle,
and JSON-LD. For instance, in JSON-LD the above graph could look like this:

```json
{"@id": "Gaiwan",
 "has_type": {"@id": "Consultancy",
              "subtype_of": "Company"},
 "specializes_in": [{"@id": "Clojure",
                     "has_type": "Programming Language"},
                    "Data Solutions"]}
```

The second important innovation of RDF is the use of URIs as identifiers. Both
entities (Gaiwan, Clojure), and predicates (has_type, specializes_in), are
represented as full URIs, for instance they might look like

- `http://www.w3.org/1999/02/22-rdf-syntax-ns#type`
- `http://www.w3.org/2000/01/rdf-schema#subClassOf`
- `https://www.w3.org/ns/activitystreams:Link`
- `https://toot.cat/users/plexus/outbox`

What makes these so great?

- They are globally unique. `"name"` can mean anything, `http://xmlns.com/foaf/0.1/name` has a well defined meaning.
- They contain an authority. Whoever controls the domain name gets to define the terms that use that domain.
- They can be dereferenced (fetched). While this isn't always the case, and isn't a requirement for RDF, it is common practice to put something on the other side of that link. For entities (subjects or objects) you may find a representation of the entity with the given id, which means you can link data the way you would link web pages. For predicates you will commonly find either a human readable or machine readable description of the vocabulary.
- They follow the logic of links with regards to a base URI. In a webpage links can be relative (for example starting with `./`, `../` or `/`). These will be resolved based on the "base" URI, the location the browser is currently on. Turtle or JSON-LD can similarly define a base URI, allowing you to shorten identifiers throughout the document.

Here's an example Turtle document taken straight from the Turtle spec:

```ttl
@base <http://example.org/> .
@prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .
@prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> .
@prefix foaf: <http://xmlns.com/foaf/0.1/> .
@prefix rel: <http://www.perceive.net/schemas/relationship/> .

<#green-goblin>
    rel:enemyOf <#spiderman> ;
    a foaf:Person ;    # in the context of the Marvel universe
    foaf:name "Green Goblin" .

<#spiderman>
    rel:enemyOf <#green-goblin> ;
    a foaf:Person ;
    foaf:name "Spiderman", "Человек-паук"@ru .
```

The identifiers `#green-goblin` and `#spiderman` are resolved starting from the
`@base`, so they are expanded to `http://example.com/#green-goblin`, and
`http://example.com/#spiderman`.

The other identifiers use prefixes, which make working with RDF much more
practical. While having full URI identifiers is great for machines processing
the data, writing them out in full is not exactly user friendly. So instead
people defined prefixes, which get substituded with a partial URI.

So `foaf:Person` instead of `http://xmlns.com/foaf/0.1/Person`.

Of course to interpret RDF data we still need to understand the vocabulary being
used. Having `http://xmlns.com/foaf/0.1/name` rather than `"name"` isn't going
to help us much if we have no idea about FOAF.

The good news is that in the preceding 20-odd years a large number of
vocabularies have been defined for use in various fields and industries. Some
are defined by the W3C, some by specialized organizations like Schema.org or
WikiData, and some by governments, corporations, or universities. Chances are
that there are standard vocabularies you can adopt, regardless of the field you
are in.

Vocabularies define types and predicates, and since both are represented with
URIs we can make statements about these as well, leading to a meta-description,
using a vocabulary known as OWL (Web Ontology Language). This allows programs to
reason about information, and infer knew information, without prior knowledge of
the vocabularies used.

