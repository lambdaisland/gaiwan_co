(ns gaiwan.about
  (:require [gaiwan.common :as common]))

(def summary
  [:div.about-summary
   [:p "Gaiwan is a software agency with a team that spans continents and
 cultures. We build opinionated products and systems that serve the people that
 use them."]
   [:p "Simplicity, and honesty are our core values. Our globally diverse team
   gives us a huge advantage, as every single member brings a different
   perspective to the table."]])

(def member-data
  [{:title "Arne Brasseur - Berlin"
    :subtitle "(@plexus)"
    :description '([:p "Arne has been delivering software solutions for well
    over a decade, as well as coaching individuals and teams on topics both
    technical and organizational."]
                   [:p "Since 2013 he's been coaching and consulting companies
                   solve complicated real world problems. He has a natural
                   instinct to break down highly complex problems and explain
                   them as a series of simple solutions."]
                   [:p "He loves a nice cup of tea, and likes to to go for runs."])}
   {:title "Felipe Barros - Recife"
    :subtitle "(@barrosfelipe)"
    :description '([:p "While still at school, GNU/Linux liberated Felipe from
                   the shackles of digital oblivion and corporate abuse."]
                   [:p "Being a keyboard enthusiast who follows the Dvorak
                   branch of the Emacs faith, he already manipulated text in Vim
                   and Emacs way before his renewed interest in computer
                   programming and cherry-picked the Clojure/ClojureScript path
                   after falling in love with Rich Hickey’s capillary
                   parentheses/curls."]
                   [:p "An arts person, likes to spend free time writing or
                   drawing and can often be caught talking about interfaces as
                   handcrafted, artisanal work."])}
   {:title "Ariel Alexi - Rosh HaAyin"
    :subtitle "(@ArielA147)"
    :description '([:p "Ariel is finishing up her last year as a Computer
                    Science student, where she built numerous projects with C++,
                    Java, Javascript, and Go. We introduced her to Clojure,
                    which she took to like fish takes to water. Her thirst for
                    knowledge has not stopped growing. "]
                   [:p "In her free time she likes to develop video games."])}
   {:title "Alys Brooks - Madison"
    :subtitle "(@alyssbrooks)"
    :description '([:p "Alyss is a professional writer and editor by day and a programmer by night. She has worked as a technical writer at Epic."]
                   [:p "She loves open source and photography."])}
   {:title "Mitesh Shah - Mumbai"
    :subtitle "(@oxalorg)"
    :description '([:p "Mitesh learnt coding because of his desire to hack video games. This slowly turned to a passion for all things computer."]
                   [:p "Since then he's launched multiple online products, co-founded his own e-grocery vegan startup, and consulted on various technologies and projects."]
                   [:p "He loves video games, dabbles in moral philosophy, and is trying to go vegan."])}
   {:title "Laurence Chen - Taipei"
    :subtitle "(@laurencechen)"
    :description '([:p "Laurence is an experienced developer with a knack for
    understanding the needs of the customer, and delivering pragmatic solutions.
    He has created bespoke systems for Taiwan-based SMBs, and offers consulting
    to the LINE corporation."])}])

(defn- team-member [data]
  (let [{:keys [title subtitle description]} data]
    [:div.team-member
     [:div.team-member__title title]
     [:div.team-member__subtitle subtitle]
     [:div.team-member__description description]]))

(def team-members
  [:div
   (for [member member-data]
     (team-member member))])

(def team
  [:div.team
   [:h1.text-bold.secondary-font "Our Team"]
   team-members])

(def work-with-us
  [:div
   [:p "Like what you see? "
    [:a {:href "mailto:arne@gaiwan.co"} "Come work with us!"]]])

(def body
  [:div.about-container
   common/navbar summary team work-with-us])

(defn about-page [content]
  [:html (common/gen-head) body])
