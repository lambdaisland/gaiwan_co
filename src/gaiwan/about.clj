(ns gaiwan.about
  (:require [gaiwan.common :as common]))

(def navbar
  [:header.about-navbar
   [:a.secondary-font.about-navbar__brand {:href "/"} "Gaiwan"]])

(def summary
  [:div.about-summary
   [:p "Far from the valleys of silicon we’re a small remote-first and highly distributed company with 5 members situated in 5 different countries. Experts at Clojure, Clojurescript, Datomic, and Emacs &mdash; we have built and launched multiple products around these technologies."]
   [:p "Simplicity, and honesty are our core values. Our globally diverse team gives us a huge advantage, as every single member brings a different perspective to the table."]])

(def member-data 
  [{:title "Arne Brasseur - Berlin"
    :subtitle "(@plexus)"
    :description '([:p "Arne has been programming for over a decade in several different industries and programming languages."]
                   [:p "Since 2013 he's been coaching and consulting companies solve complicated real world problems. He has a natural instinct to break down highly complex problems and explain them as a series of simple solutions."]
                   [:p "He's well regarded in the Clojure community for making web development easy with Chestnut, for creating the Kaocha test runner, for running the ClojureVerse community forum, and for organizing the Heart of Clojure conference."]
                   [:p "He loves drinking tea, and taking long runs in the nature!"])}
   {:title "Felipe Barros - Recife"
    :subtitle "(@barrosfelipe)"
    :description '([:p "Felipe has been using Linux since as long as he can remember. Being an Emacs wizard with an eye for design gives him superpowers!"]
                   [:p "He loves using Clojure and Clojurescript."])}
   {:title "Ariel Alexi - Rosh HaAyin"
    :subtitle "(@ArielA147)"
    :description '([:p "Ariel joined Gaiwan immediately after finishing her univerity in Computer science. Having built numerous projects with C++, Java, Javascript, and Go, her thirst for knowledge has not stopped growing. She is now progressing her way through Clojure."]
                   [:p "In her free time she likes to develop video games."])}
   {:title "Alys Brooks - Madison"
    :subtitle "(@alyssbrooks)"
    :description '([:p "Alyss is a professional writer and editor by day and a programmer by night. She has worked as a techncial writer at Epic."]
                   [:p "She loves open source and photography."])}
   {:title "Mitesh Shah - Mumbai"
    :subtitle "(@oxalorg)"
    :description '([:p "Mitesh learnt coding because of his desire to hack video games. This slowly turned to a passion for all things computer."]
                  [:p "Since then he's launched multiple online products, co-founded his own e-grocery vegan startup, and consulted on various technologies and projects."]
                  [:p "He loves video games, dabbles in moral philosophy, and is trying to go vegan."])}])

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
   navbar summary team work-with-us])

(defn about-page [content]
  ["<!DOCTYPE html>\n"
   [:html (common/gen-head) body]])