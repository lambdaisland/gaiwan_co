---
title: "Gaiwan's Clojure Dev Tooling & Docs Week"
slug: clojure-dev-tooling-docs-checkup
description: |-
    Invite the Gaiwan Team over for a week improve your setup, and to help boost 
    your team's productivity. Everything from having a good REPL experience, a solid test 
    setup, and a reloadable workflow, up to having a kick-ass onboarding experience for 
    the next person to join.
---

# Gaiwan's Clojure Dev and Docs Week

As a consultancy we get to see a lot of code bases, and it's always interesting
to see how different teams approach their setup and architecture. There's no
one-size-fits-all, and that's especially true in the Clojure world, where people
are encouraged to put together a stack to their liking.

Unfortunately what we often see is that the dev experience suffers. It's easy to
set things up in a way that hinders a good REPL-based workflow. Sometimes
there's not even a working REPL setup, or there will be one for Clojure but not
for ClojureScript.

We also see that more often than not the dev setup and tooling isn't documented.
We expect a project's README to contain all the necessary information to get up
and running, to run tests from the REPL or terminal, to set up databases and
other dependencies. More often than not that information is missing, incorrect,
or incomplete.

Over the last few years doing a checkup of these things has become fairly
routine, we have a checklist and some established patterns, and so the first
thing we do with new clients is making sure these things are in order. This
helps the existing team, but it's even more important for new hires. It can
transform the onboarding experience from days of pairing to just going over the
README in under an hour.

We are convinced this kind of checkup could help many Clojure teams out there,
which is why we've decided to offer this as a standalone package. 

We spend a week with your team, we start by solliciting input from the
developers about existing frustrations, we also go over our checklist to see if
the basics are covered. The rest of the week we make as many improvements as we
can. At the end of the week you get a list of recommendations of the remaining
improvements that we recommend. All of this for a one-time cost of €4500.

Typically things we check for:

- A completely updated README, for super speedy onboarding
- Streamline onboarding by minimizing required local configuration, and handling common mistakes gracefully, like forgetting to start the database
- Working Clojure and ClojureScript (n)REPLs
- Editor-specific instructions, depending on the team's preference
- Emacs-specific integration (if there are Emacs users) via `.dir-locals.el`, so that a `cider-jack-in-clj&cljs` is all you need
- Quick REPL startup time, by using the `jit` pattern in `user.clj`
- Standard `user` helpers: `(go)`, `(browse)`, `(reset)`, `(system)`, etc.
- A reloadable workflow, no errors when calling `(reset)`
- Review of the Kaocha configuration and recommended plugins
- Instructions for running tests from the REPL or command line, including in watch mode
- Repl-able http handlers, redefine Ring handler functions without having to reset the system
- REPL+terminal tools/tasks like db setup, migrations, linting
- Review logging setup, make sure there's a single logging sink setup, and that all logging facades/APIs pipe into it
- Make sure it's easy to change log levels during development, to dial the level of detail up or down

```hiccup
[cta/section 
 {:title "Gaiwan Dev Tooling & Docs Week" 
  :subtitle "€ 4500 One-time Cost"
  :link "mailto:contact@gaiwan.co?subject=Dev+Tooling+and+Docs+Week"
  :button-text "Contact us!"}]
```
