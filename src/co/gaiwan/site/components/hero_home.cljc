(ns co.gaiwan.site.components.hero-home
  (:require [co.gaiwan.site.utils :as utils]))

(defn hero-home []
  [:section {:class "relative"}
   [:div {:style (str "background-image: url(" (utils/img "pattern.svg")");z-index: -1")
          :class "bg-repeat absolute w-full h-full top-0 pointer-events-none opacity-10"}]
   [:div {:class "max-w-6xl mx-auto pt-16 px-4 sm:px-6 z-10 "}
    #_[:comment " Hero content "]
    [:div {:class "pt-16 pb-12 md:pt-32 md:pb-24"}
     #_[:comment " Section header "]
     [:div {:class "text-center pb-12 md:pb-16 relative"}
      [:h1
       {:class
        "text-4xl md:text-5xl font-extrabold leading-tighter tracking-tighter mb-4",
        :data-aos "zoom-y-out"} "Clojure & ClojureScript "
       [:span
        {:class
         "block bg-clip-text text-transparent bg-gradient-to-r from-blue-500 to-green-400"}
        "consultancy"]]
      [:div {:class "max-w-xl mx-auto"}
       [:p
        {:class "text-xl text-gray-600 mt-8 mb-12",
         :data-aos "zoom-y-out",
         :data-aos-delay "150"}
        "Gaiwan seeks to improve upon common IT industry practices, by making
        deliberate technological choices and focusing on simplicity. They use
        Clojure, a language known for its high developer productivity. Gaiwan
        develops several popular Clojure libraries, benefiting their clients,
        their own projects, and the wider Clojure community, and making the
        language itself more attractive. By strengthening Clojure and its
        ecosystem, Gaiwan contributes to enhancing the IT industry as a whole."]
       [:div
        {:class "max-w-xs mx-auto sm:max-w-none sm:flex sm:justify-center",
         :data-aos "zoom-y-out",
         :data-aos-delay "300"}
        [:div
         [:a
          {:class
           "btn text-white bg-blue-600 hover:bg-blue-700 w-full mb-4 sm:w-auto sm:mb-0",
           :href "mailto:contact@gaiwan.co"} "Get in touch"]]
        [:div
         [:a
          {:class
           "btn text-white bg-gray-900 hover:bg-gray-800 w-full sm:w-auto sm:ml-4",
           :href "#team"} "Meet the team"]]]]]
     #_[:comment " Hero image "]
     #_[:div {:x-data "{ modalExpanded: false }"}
        [:div
         {:class "relative flex justify-center mb-8",
          :data-aos "zoom-y-out",
          :data-aos-delay "450"}
         [:div {:class "flex flex-col justify-center"}
          [:img
           {:alt "Hero",
            :class "mx-auto rounded shadow-xl",
            :height "432",
            :src "../images/hero-image-01.png",
            :width "768"}]
          [:svg
           {:class "absolute inset-0 max-w-full mx-auto md:max-w-none h-auto",
            :height "432",
            :viewbox "0 0 768 432",
            :width "768",
            :xmlns "http://www.w3.org/2000/svg",
            :xmlns:xlink "http://www.w3.org/1999/xlink"}
           [:defs
            [:lineargradient#hero-ill-a
             {:x1 "50%", :x2 "50%", :y1 "0%", :y2 "100%"}
             [:stop {:offset "0%", :stop-color "#FFF"}]
             [:stop {:offset "77.402%", :stop-color "#EAEAEA"}]
             [:stop {:offset "100%", :stop-color "#DFDFDF"}]]
            [:lineargradient#hero-ill-b
             {:x1 "50%", :x2 "50%", :y1 "0%", :y2 "99.24%"}
             [:stop {:offset "0%", :stop-color "#FFF"}]
             [:stop {:offset "48.57%", :stop-color "#EAEAEA"}]
             [:stop {:offset "100%", :stop-color "#DFDFDF", :stop-opacity "0"}]]
            [:radialgradient#hero-ill-e
             {:cx "21.152%",
              :cy "86.063%",
              :fx "21.152%",
              :fy "86.063%",
              :r "79.941%"} [:stop {:offset "0%", :stop-color "#4FD1C5"}]
             [:stop {:offset "25.871%", :stop-color "#81E6D9"}]
             [:stop {:offset "100%", :stop-color "#338CF5"}]]
            [:circle#hero-ill-d {:cx "384", :cy "216", :r "64"}]]
           [:g {:fill "none", :fill-rule "evenodd"}
            [:circle
             {:cx "384",
              :cy "216",
              :fill "url(#hero-ill-a)",
              :fill-opacity ".04",
              :r "128"}]
            [:circle
             {:cx "384",
              :cy "216",
              :fill "url(#hero-ill-b)",
              :fill-opacity ".16",
              :r "96"}]
            [:g {:fill-rule "nonzero"}
             [:use {:fill "#000", :xlink:href "#hero-ill-d"}]
             [:use {:fill "url(#hero-ill-e)", :xlink:href "#hero-ill-d"}]]]]]
         [:button
          {:aria-controls "modal",
           :class
           "absolute top-full flex items-center transform -translate-y-1/2 bg-white rounded-full font-medium group p-4 shadow-lg"}
          [:svg
           {:class
            "w-6 h-6 fill-current text-gray-400 group-hover:text-blue-600 flex-shrink-0",
            :viewbox "0 0 24 24",
            :xmlns "http://www.w3.org/2000/svg"}
           [:path
            {:d
             "M12 22c5.523 0 10-4.477 10-10S17.523 2 12 2 2 6.477 2 12s4.477 10 10 10zm0 2C5.373 24 0 18.627 0 12S5.373 0 12 0s12 5.373 12 12-5.373 12-12 12z"}]
           [:path {:d "M10 17l6-5-6-5z"}]]
          [:span {:class "ml-3"} "Watch the full video (2 min)"]]]
        #_[:comment " Modal backdrop "]
        #_[:div
           {:aria-hidden "true",
            :class
            "fixed inset-0 z-50 bg-white bg-opacity-75 transition-opacity blur",
            :x-show "modalExpanded",
            :x-transition:enter "transition ease-out duration-200",
            :x-transition:enter-end "opacity-100",
            :x-transition:enter-start "opacity-0",
            :x-transition:leave "transition ease-out duration-100",
            :x-transition:leave-end "opacity-0",
            :x-transition:leave-start "opacity-100"}]
        #_[:comment " Modal dialog "]
        #_[:div#modal
           {:aria-labelledby "modal-headline",
            :aria-modal "true",
            :class
            "fixed inset-0 z-50 overflow-hidden flex items-center justify-center transform px-4 sm:px-6",
            :role "dialog",
            :x-show "modalExpanded",
            :x-transition:enter "transition ease-out duration-200",
            :x-transition:enter-end "opacity-100 scale-100",
            :x-transition:enter-start "opacity-0 scale-95",
            :x-transition:leave "transition ease-out duration-200",
            :x-transition:leave-end "opacity-0 scale-95",
            :x-transition:leave-start "opacity-100 scale-100"}
           [:div {:class "bg-white overflow-auto max-w-6xl w-full max-h-full"}
            [:div {:class "relative pb-9/16"}
             [:iframe
              {:class "absolute w-full h-full",
               :src "https://www.youtube.com/embed/qz4F1uMzihY",
               :title "Video"}]]]]]]]])
