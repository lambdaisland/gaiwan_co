---
date: 2022-06-08
title: "Still Beating the Averages"
slug: "still-beating-the-averages"
author: "Joshua Ballanco"
---

It has been just over 20 years since Paul Graham published ["Beating the Averages"](http://www.paulgraham.com/avg.html), one of his more famous articles. While it is perhaps most recognized for its emphatic endorsement of Lisp, Paul Graham's larger point in the article (and source of the title) is that the "average" startup goes out of business. To be successful, he argues, you need to do something to set yourself apart -- to be "above average" -- and using Lisp is one way a startup can be above average.

At Gaiwan, we definitely agree that Lisp (or, in our case, Clojure) is a super-powered programming language that can empower a team of developers to beat the average. Indeed, some of us have been using Clojure for over a decade to help both startups and large organizations succeed. That said, upon re-reading "Beating the Averages", one notices a flaw in Paul Graham's argument for choosing Lisp.

Before we can examine that flaw, it is necessary to review the concept of technical debt. In the same way that you might take on debt in order to buy a house before you have saved enough to buy it on your own, taking on technical debt allows you to ship features before you would be able to if you had developed the feature "the right way". In other words: technical debt is a short-cut that you take but will eventually have to replace.

Paul Graham points out in his essay that the portions of ViaWeb, his startup, that he and Robert Morris had originally written in Lisp had likely already been replaced with another language. Reddit, a startup that emerged from Paul Graham's Y-Combinator startup accelerator, also wrote their first version using Lisp, only to quickly replace it with Python.

How is it that Lisp, a super-powered programming language, was treated in these two examples as if it were technical debt? If Lisp can dramatically improve programmer productivity, why not continue using it? The answer can be found right in the text of the original article:

> After a certain age, programmers rarely switch languages voluntarily. Whatever language people happen to be used to, they tend to consider just good enough.
    
 With a combination of good fortune and good planning, *some* technology start-ups manage to "make it". After they gain a foothold on the market, they get funding to build out their product "the right way". Still, the need to develop more new features faster than the competition never really goes away. What changes is the calculus of how best to achieve that goal.
 
 The best technology in the world can only increase developer productivity so much. At some point, the best way to increase the rate at which you can develop new features is to grow your team. However, if the available pool of Lisp developers is smaller than the available pool of developers from some other language, and if you believe Paul Graham that "programmers rarely switch languages", then being forced to switch away from Lisp seems inevitable.
 
 "Beating the Averages" makes a compelling case that a start-up consisting of a small team of Lisp developers has a strategic advantage. It would seem to follow that a large organization of Lisp developers would, likewise, have a strategic advantage. The problem is how to get from point A to point B.
 
 Another way of looking at this challenge is to consider which decision is the actual technical debt: the decision to use Lisp at the start? or in the decision to abandon it later? If technical debt is a short-cut you take in order to deliver features faster than you otherwise might, then it would seem that abandoning Lisp in order to facilitate hiring is the true technical debt. But how can this be? Teams that start off with a Lisp, but then move away from it later, don't re-implement everything in Lisp after the hiring is done. So is abandoning Lisp really technical debt?
 
 The sad reality is that most technical debt never gets paid. Companies that start off using Lisp would be better off, in the long run, if they continued using Lisp. The best way to avoid having to pay for technical debt is to avoid taking it on in the first place. So, how is a company to do that? How can a company grow with Lisp?
 
 While there are no silver bullets, at Gaiwan we have developed an approach that we've found works rather well:
 * Reach beyond the traditional pool of developer talent. If we assume that developer talent is evenly distributed across the entire population, and that underrepresented groups are underrepresented because they did not have the same exposure or access to the resources needed to develop those talents, then that means there is a large pool of untapped talent in underrepresented groups. More importantly, it's untapped talent that you don't have to convince to switch languages. Instead, you can start them off right with Clojure from the start.
 * Make it easier for developers who *are* willing to voluntarily switch languages to do so. One reason experienced developers rarely switch languages is because it means they must spend some amount of time on a new project being less productive than they are used to being. It is possible to develop code, infrastructure, and the on-boarding tools to go along with it all in a way that eases this transition period.
 * Go to where the talent is. Some of us have been working remotely for a decade before the COVID-19 pandemic set in, and we know the simple truth behind remote work: if you want the best developers, you have to be willing to go to where they are. That means being flexible with both time and location.
 * Focus on continuing education. Clojure is an extremely powerful language, but tapping into that power fully requires one to take the approach of being an eternal student. If even the most experienced developers on a team are constantly learning, then developers who are either new to Clojure or new to programming will be more willing to ask the questions they need to in order to develop their own skills.
 * Engage with the community. Especially when a team is small, being able to count on a community of developers that reaches beyond the developers or your own team is vital to being able to find the tools or ask the questions you need to in order to achieve everything else in this list.
 
Paul Graham concluded "Beating the Averages" by admitting:

>  The purpose of this article is not to change anyone's mind, but to reassure people already interested in using Lisp -- people who know that Lisp is a powerful language, but worry because it isn't widely used.

Well, the purpose of this article is, similarly to reassure anyone already interested in using Clojure, either for a start-up or for new development within a larger organization: you don't have to worry about growing your team alone. We're here to help you!
