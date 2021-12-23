(ns gaiwan.about
  (:require [gaiwan.data :as data]))

(def summary
  [:div.about-summary
   [:p "Gaiwan is a software agency with a team that spans continents and
 cultures. We build opinionated products and systems that serve the people that
 use them."]
   [:p "Simplicity, and honesty are our core values. Our globally diverse team
   gives us a huge advantage, as every single member brings a different
   perspective to the table."]])

(defn- team-member [data]
  (let [{:keys [title subtitle description]} data]
    [:div.team-member
     [:div.team-member__title title]
     [:div.team-member__subtitle subtitle]
     [:div.team-member__description description]]))

(def team-members
  [:div
   (for [member data/team-members]
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
   summary team work-with-us])
