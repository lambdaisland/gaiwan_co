(ns gaiwan.home
  (:require [gaiwan.common :as common]))

(def section-hero
  [:section {:id "hero"}
   [:article {:class "hero-grid"}
    [:h1 {:class "logo"} "Gai"
     [:spam {:class "gaiwan-kerning"} "w"] "an"]
    [:div {:class "text-box"}
     [:aside {:class "quote"}
      [:blockquote {:class "blockquote"}
       [:p "“In the past decade I’ve become known as a reliable partner who delivers, and have built up ex­per­tise through con­tin­u­ous study, shipping software, and teaching others. Gaiwan is driven by the same prin­ci­ples that made my work successful.”"]
       [:footer "— Arne Brasseur"]]]
     [:div {:class "description"}
      [:p
       [:strong "We are a provider of technological exper­tise"] " grown out of the consulting and de­vel­op­ment work of Arne Brasseur."]
      [:p "Our job is to find a path from a business need to a technical solution that ensures we can deliver quality and reliability within time and budget. To do so we are highly opinionated when it comes to choosing the software components we build on, and we work closely with customers to come up with pragmatic solutions that work."]
      [:div.hero-nav
       "Learn more about "
       [:a {:href "/about"} "our team."]]]]]])

(def section-client-work
  [:section {:id "client-work"}
   [:div.nextjournal
    [:article
     [:header
      [:img {:alt "Nextjournal", :src "./imgs/nextjournal-logo.svg", :class "logo"}]]
     [:div {:class "client-description-wrapper"}
      [:p
       [:a {:href "https://nextjournal.com/"} "Nextjournal"] " is offering a Data Science product that aims to solve some of the issues faced by scientific publishing."]
      [:p "We have worked with Nextjournal for a large part of their journey, providing consulting to make sure their team could stay on track. This has included tooling improvements, architectural feedback, improvements to their testing approaches, and one-on-one coaching sessions with their developers."]]]]
   [:div.eleven
    [:article
     [:header
      [:img {:src "./imgs/eleven-logo.svg", :alt "Eleven", :itemprop "logo", :class "logo"}]]
     [:div {:class "client-description-wrapper"}
      [:p
       [:a {:href "http://runeleven.com/"} "Eleven"] " is on a mission to end suffering in the world of accounting. They are building an ambitious new accounting product that needs to lift accounting practices into the 21st century."]
      [:p "Eleven chose the business intelligence tool "
       [:a {:href "http://metabase.com/"} "Metabase"] " so they could put flexible querying capabilities into the hands of their clients. Gaiwan was comissioned to create the "
       [:a {:href "https://github.com/plexus/metabase-datomic"} "Datomic database driver"] " for Metabase, and worked with Eleven to integrate Metabase into their system."]]]]
   [:div {:class "mein-grundeinkommen"}
    [:article
     [:header
      [:img {:alt "Mein Grundeinkommen", :src "./imgs/mge-logo.svg", :class "logo"}]]
     [:div
      [:p "The German non-profit "
       [:a {:lang "de", :href "https://www.mein-grundeinkommen.de/"} "Mein Grundeinkommen"] " strives for the introduction of basic income. The money they collect through fund-raising is used to provide people with basic income for a year through a lottery system."]
      [:p "The selection of new beneficiaries is preceded by large on-line campaigns where people register for the lottery, and possible become patrons."]
      [:p "We assisted "
       [:spam {:lang "de"} "Mein Grundeinkommen"] " with the construction and load testing of these campaign workflows. We also created an internal tool for them called Marimba, which allowed them to run their mass email campaigns efficiently with a fraction of the cost."]]]]])

(def section-portfolio
  [:section {:id "portfolio"}
   [:h2 "Our Projects"]
   [:article
    [:header
     [:h3 "Lambda Island"]]
    [:p
     [:a {:href "https://lambdaisland.com/"} "Lambda Island"] " is our technical brand, aimed at developers who want to become better at what they do. It forms a key part of the Gaiwan success formula. By constantly researching deep technical topics and making them easily digestible we build up a knowledge and expertise in-house, which directly improves our client work."]]
   [:article
    [:header
     [:h3 "Lambda Island Open Source"]]
    [:p "All Gaiwan engineers are active open source contributors, and we have several open source libraries we created and maintain, available through the "
     [:a {:href "https://github.com/lambdaisland"} "Lambda Island"] " brand."]
    [:p "These projects often stem from needs we saw in client projects, or in the community in general. By opening them up we make sure we can use these building blocks on subsequent projects. It also enables contributions from other members of the technical community."]]
   [:article
    [:header
     [:h3 "Heart of Clojure"]]
    [:p
     "Gaiwan GmbH is the initiator and legal entity backing the "
     [:a {:href "https://heartofclojure.eu/"} "Heart of Clojure"]
     " community conference. We provide the organizational infrastructure to be able to pull off such an event, and manage a big chunk of the work that goes into organizing. We also provide a “parachute sponsorship”, patching up any holes in the budget that may arise."]]])

(def body
  [:body
   [:main
    section-hero
    section-client-work
    section-portfolio]
   common/footer])

(defn home-page [content]
  [:html (common/gen-head) body])
