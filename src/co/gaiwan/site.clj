(ns co.gaiwan.site
  (:require [co.gaiwan.site.blog :as blog]
            [co.gaiwan.site.data :as data]
            [co.gaiwan.site.home :as home]
            [co.gaiwan.site.markdown :as md]
            [co.gaiwan.site.pages :as pages]
            [co.gaiwan.site.work :as work]
            [nuzzle.core :as nuzz]))

(defn pages []
 {[]
  {:nuzzle/title data/site-title
   :nuzzle/render-page home/get-home}

  [:work]
  {:nuzzle/title "Our Work - Gaiwan Team"
   :nuzzle/summary "Projects built by the Gaiwan team. We use clojure and clojurescript to solve critical problems for our clients."
   :nuzzle/render-page work/get-work}

  [:clojure-dev-tooling-docs-checkup]
  {:nuzzle/title "Gaiwan's Clojure Dev Tooling & Docs Week"
   :nuzzle/render-page pages/get-generic
   :nuzzle/render-content #(md/md-content "pages/dev_checkup.md")
   :nuzzle/summary "Invite the Gaiwan Team over for a week improve your setup, and to help boost your team's productivity. Everything from having a good REPL experience, a solid test setup, and a reloadable workflow, up to having a kick-ass onboarding experience for the next person to join."}

  [:blog]
  {:nuzzle/title "Gaiwan Blog"
   :nuzzle/summary "The Gaiwan Blog"
   :nuzzle/render-page blog/get-blog}

  [:blog :itrevolution-devops-enterprise-summit]
  {:nuzzle/title "Delivering devops enterprise summit"
   :nuzzle/render-page blog/get-blog-item
   :nuzzle/render-content #(md/md-content "blog/delivering-devops-enterprise-summit.md")
   :nuzzle/published #inst "2021-06-01"
   :nuzzle/feed true
   :nuzzle/author (data/authors :mitesh)}

  [:blog :growing-our-team]
  {:nuzzle/title "Growing the Gaiwan team"
   :nuzzle/render-page blog/get-blog-item
   :nuzzle/render-content #(md/md-content "blog/growing-our-team.md")
   :nuzzle/published #inst "2020-11-01"
   :nuzzle/feed true
   :nuzzle/author (data/authors :mitesh)}

  [:blog :still-beating-the-averages]
  {:nuzzle/title "Still Beating the Averages"
   :nuzzle/render-page blog/get-blog-item
   :nuzzle/render-content #(md/md-content "blog/still_beating_the_averages.md")
   :nuzzle/published #inst "2022-06-08"
   :nuzzle/author (data/authors :josh)
   :nuzzle/feed true}

  [:version]
  {:nuzzle/title "Site Version"
   :nuzzle/render-page pages/get-version}})

(defn develop [& _]
  (nuzz/develop #'pages {:overlay-dir "resources"
                         :refresh-interval 2500}))

(defn serve [& _]
  (nuzz/serve #'pages {:overlay-dir "resources"
                       :refresh-interval 2500}))

(defn publish [& _]
  (nuzz/publish pages {:overlay-dir "resources"
                       :base-url data/base-url
                       :atom-feed {:title "Gaiwan Blog"
                                   :description "The Gaiwan Blog"}
                       :publish-dir "_site"}))
