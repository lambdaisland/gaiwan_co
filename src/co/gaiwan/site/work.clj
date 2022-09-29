(ns co.gaiwan.site.work
  (:require [co.gaiwan.site.data :as data]
            [co.gaiwan.site.layout :as layout]
            [co.gaiwan.site.open-graph :as og]))

(defn project [{:keys [client title description cta-text cta-url image-url]}]
  [:div {:class "w-full"}
   [:div {:class "flex flex-col lg:flex-row"}
    [:div {:class "w-full lg:w-1/2"}
     [:div
      {:class "mx-4 mt-12 text-center p-4"}
      [:img {:alt "" :class "rounded" :src image-url}]]]
    [:div {:class "w-full lg:w-1/2"}
     [:div
      {:class "mt-12 about-content wow fadeInLeftBig"}
      [:p
       [:span
        {:class "bg-clip-text text-transparent bg-gradient-to-r from-blue-500
                to-green-400 font-bold text-upper"}
        client]
       [:h3 {:class "text-xl font-bold mb-2"} title]]
      [:p {:class "mb-8"}
       description]
      [:a {:class "underline hover:text-gray-900 transition duration-150 ease-in-out"
           :href cta-url}
       cta-text]]]
    ]]
  )

(defn body []
  [:section
   [:div {:class "max-w-6xl mx-auto px-4 sm:px-6"}
    [:div {:class "pt-24 pb-12 md:pt-32 md:pb-20"}
     [:div {:class "max-w-3xl pb-12 md:pb-20 text-center md:text-left"}
      [:h1 {:class "h1 mb-4"} "Built by Gaiwan"]
      [:p {:class "text-xl text-gray-600"}
       "We are fully commited to help our clients achieve their success. We do
        this through unwavering honesty and transparency while working
        together."]]
     [:div {:class "md:flex md:justify-between"}
      [:div {:class "md:flex-grow -mt-4"}
       (for [p data/projects]
         (project p))]]]]])

(defn get-work [page]
  (layout/layout
   (og/social-tags page)
   (body)))
