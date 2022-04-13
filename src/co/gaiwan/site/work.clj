(ns co.gaiwan.site.work
  (:require [co.gaiwan.site.utils :as utils]))

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
       [project {:client "IT Revolution"
                 :title "Bespoke conference video editor"
                 :description
                 "ITRevolution hosts the biggest Devops conference - the DevOps
                 Enterprise Summit. During the pandemic they shifted from
                 in-person to a completely online conference which came with a
                 host of problems. We helped them transition their entire
                 operations to a cloud native solution. We also helped their
                 team to be able to edit over 100 videos per conference
                 fulfilling all of their custom operations using our in-house
                 video editor frontend which uses FFMPEG DSL behind the scenes."
                 :cta-text "Read in-depth of how we built it"
                 :cta-url "https://itrevolution.com"
                 :image-url (utils/img "work/itrev-video-editor.png")}]
       [project {:client "re:Clojure Conf"
                 :title "Built & Redesigned the reclojure.org website"
                 :description
                 "Gaiwan loves Clojure, which is why we love supporting
                 community events like re:Clojure. You may have seen the amazing
                 event website? That was us. A lightweight design, leveraging
                 web standards for maximum accessibility, and a responsive
                 experience across devices, all in an appealing package."
                 :cta-text nil
                 :cta-url nil
                 :image-url (utils/img "work/reclojure.png")}]
       [project {:client "Pitch"
                 :title "Integration with a popular chatting service"
                 :description
                 "We helped Pitch in building a complex ClojureScript test
                 runner suited to their codebase. We also helped in integrating
                 the Pitch app into an extremely popular chatting service."
                 :cta-text nil
                 :cta-url nil
                 :image-url (utils/img "work/pitch.png")}]
       [project {:client "Eleven"
                 :title "Metabase integration and financial queries"
                 :description
                 "We created the metabase driver for Datomic for Eleven and also
                 open-sourced it. We then helped create and integrate their
                 complicated financial reporting with metabase resulting in some
                 pretty sweet graphs for their clients!."
                 :cta-text nil
                 :cta-url nil
                 :image-url (utils/img "work/eleven.png")}]
       ]]]]])
