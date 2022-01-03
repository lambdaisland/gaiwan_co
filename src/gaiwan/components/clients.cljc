(ns gaiwan.components.clients
  (:require [gaiwan.utils :as utils]))

(defn wave
  []
  [:div {:style "height: 150px; overflow: hidden; margin-top: -100px;"}
   [:svg
    {:preserveaspectratio "none",
     :style "height: 100%; width: 100%;",
     :fill "currentColor",
     :class "text-blue-100",
     :viewbox "0 0 500 150"}
    [:path
     {:d
        "M-2.45,75.95 C129.61,193.43 379.04,-8.67 500.93,105.82 L500.00,150.33 L0.00,150.33 Z",
      :style "stroke: none;"}]]])

(defn logo-cloud
  []
  [:div {:class "bg-blue-100"}
   [:div {:class "max-w-7xl mx-auto py-12 px-4 sm:px-6 lg:px-8"}
    [:div {:class "grid grid-cols-2 gap-8 md:grid-cols-6 lg:grid-cols-5"}
     [:div {:class "col-span-1 flex justify-center md:col-span-2 lg:col-span-1"}
      [:img {:alt "MGE", :class "h-12", :src (utils/img "mge-logo.svg")}]]
     [:div]]]])

(defn card
  [{:keys [image text]}]
  [:div {:class "md:flex md:flex-col p-4"}
   [:div {:class "md:flex-shrink-0"}
    [:img {:alt "", :class "h-12 pt-2 mx-6", :src image}]]
   [:blockquote {:class "mt-6 md:flex-grow md:flex md:flex-col mx-6"}
    [:div {:class "relative text-lg text-black md:flex-grow"}
     [:svg
      {:aria-hidden "true",
       :class
       "absolute top-0 left-0 transform -translate-x-10 -translate-y-2 h-8 w-8 text-nextjournal",
       :fill "currentColor",
       :viewbox "0 0 32 32"}
      [:path
       {:d
        "M9.352 4C4.456 7.456 1 13.12 1 19.36c0 5.088 3.072 8.064 6.624 8.064 3.36 0 5.856-2.688 5.856-5.856 0-3.168-2.208-5.472-5.088-5.472-.576 0-1.344.096-1.536.192.48-3.264 3.552-7.104 6.624-9.024L9.352 4zm16.512 0c-4.8 3.456-8.256 9.12-8.256 15.36 0 5.088 3.072 8.064 6.624 8.064 3.264 0 5.856-2.688 5.856-5.856 0-3.168-2.304-5.472-5.184-5.472-.576 0-1.248.096-1.44.192.48-3.264 3.456-7.104 6.528-9.024L25.864 4z"}]]
     [:p {:class "relative"} text]]
    #_[:footer {:class "mt-8"}
       [:div {:class "flex items-start"}
        [:div
         {:class "flex-shrink-0 inline-flex rounded-full border-2 border-white"}
         [:img
          {:alt "",
           :class "h-12 w-12 rounded-full",
           :src
           "https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80"}]]
        [:div {:class "ml-4"}
         [:div {:class "text-base font-medium text-black"} "Judith Black"]
         [:div {:class "text-base font-bold text-nextjournal"}
          "CEO, Nextjournal"]]]]]])


(def card-list
  [:section {:class "bg-blue-100 pb-12"}
   [:div
    {:class
     "max-w-7xl mx-auto md:grid md:grid-cols-2 md:gap-x-4 md:gap-y-12 md:px-6 lg:px-8"}
    [card
     {:image (utils/img "pitch-logo.png"),
      :text
      "We worked with Gaiwan on a complex ClojureScript test runner, and
an integration of our product with a popular service. In both instances, they
managed their time and resources well, effectively navigated unknowns, delivered
high-quality code and communicated clearly. We had nothing but positive
feedback, and would highly recommend Gaiwan as a partner."}]
    [card
     {:image (utils/img "itrev-logo.png"),
      :text
      "The Gaiwan team helped us deliver a flawless attendee experience for
our conferences. They have created a Bespoke editing and rendering tool to meet
ITRev's needs. Created a live streaming conference platform and integrated it
into several services and much more. It has been a delight working with them.
"}]
    [card
     {:image (utils/img "nextjournal-logo.svg"),
      :text
      "We have worked with the Gaiwan team for a large part of our
         journey. This has included tooling improvements,
         architectural feedback, improvements to our testing
         approaches, and one-on-one coaching sessions with our
         developers."}]
    [card
     {:image (utils/img "eleven-logo.svg"),
      :text
      "Gaiwan was comissioned to create the Datomic database driver
         for Metabase, and worked with Eleven to integrate Metabase
         into our system. They completely took the pain away from us
         and let us focus on our core product."}]]])

(defn testimonial []
  [:div {:class ""}
   (wave)
   card-list])
