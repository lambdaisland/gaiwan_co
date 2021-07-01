(ns gaiwan.components.header
  (:require [gaiwan.components.logo :as logo]))

(defn top []
  [:html
   [:body
    [:header
     {:class
      "relative w-full z-30 bg-white blur shadow-lg transition duration-300 ease-in-out",
      :x-data "{ top: true }"}
     [:div {:class "max-w-6xl mx-auto px-5 sm:px-6"}
      [:div {:class "flex items-center justify-between h-16 md:h-20"}
       #_[:comment " Site branding "]
       [:div {:class "flex-shrink-0 mr-4"}
        #_[:comment " Logo "]
        [:a {:aria-label "Cruip", :class "text-xl block secondary-font", :href "/"}
         "GAIWAN"]]
       #_[:comment " Desktop navigation "]
       [:nav {:class "hidden md:flex md:flex-grow"}
        [:ul {:class "flex flex-grow justify-end flex-wrap items-center"}
         [:li
          [:a
           {:class
            "text-gray-800 font-bold hover:text-gray-900 px-3 lg:px-5 py-2 flex items-center transition duration-150 ease-in-out",
            :href "#"} "OUR WORK"]]
         [:li
          [:a
           {:class
            "text-gray-800 font-bold hover:text-gray-900 px-3 lg:px-5 py-2 flex items-center transition duration-150 ease-in-out",
            :href "/blog/"} "BLOG"]]
         [:li
          [:a
           {:class
            "font-medium text-gray-600 hover:text-gray-900 px-5 py-3 flex items-center transition duration-150 ease-in-out",
            :target "_blank"
            :href "https://lambdaisland.com"} "LambdaIsland.com"]]
         [:li
          [:a
           {:class "btn-sm text-gray-200 bg-gray-900 hover:bg-gray-800 ml-3",
            :href "mailto:contact@gaiwan.co"} [:span "Say hi"]
           [:svg
            {:class "w-3 h-3 fill-current text-gray-400 flex-shrink-0 ml-2 -mr-1",
             :viewbox "0 0 12 12",
             :xmlns "http://www.w3.org/2000/svg"}
            [:path
             {:d
              "M11.707 5.293L7 .586 5.586 2l3 3H0v2h8.586l-3 3L7 11.414l4.707-4.707a1 1 0 000-1.414z",
              :fill-rule "nonzero"}]]]]]]
       #_[:comment " Mobile menu "]
       [:div {:class "flex md:hidden", :x-data "{ expanded: false }"}
        #_[:comment " Hamburger button "]
        [:button
         {:aria-controls "mobile-nav",
          :class "hamburger",
          ::aria-expanded "expanded",
          ::class "{ 'active': expanded }"} [:span {:class "sr-only"} "Menu"]
         [:svg
          {:class "w-6 h-6 fill-current text-gray-900",
           :viewbox "0 0 24 24",
           :xmlns "http://www.w3.org/2000/svg"}
          [:rect {:height "2", :width "24", :y "4"}]
          [:rect {:height "2", :width "24", :y "11"}]
          [:rect {:height "2", :width "24", :y "18"}]]]
        #_[:comment " Mobile navigation "]
        [:nav#mobile-nav
         {:class
          "hidden absolute top-full h-screen pb-16 z-20 left-0 w-full overflow-scroll bg-white transition-all duration-300 ease-in-out",
          :x-show "expanded",
          :x-transition:enter "transition ease-out duration-200 transform",
          :x-transition:enter-end "opacity-100 translate-y-0",
          :x-transition:enter-start "opacity-0 -translate-y-2",
          :x-transition:leave "transition ease-out duration-200",
          :x-transition:leave-end "opacity-0",
          :x-transition:leave-start "opacity-100"}
         [:ul {:class "px-5 py-2"}
          #_[:li
             [:a
              {:class "flex text-gray-600 hover:text-gray-900 py-2",
               :href "#"} "Our clients"]]
          [:li
           [:a
            {:class "flex text-gray-600 hover:text-gray-900 py-2",
             :href "/about/"} "About us"]]
          #_[:li
             [:a
              {:class "flex text-gray-600 hover:text-gray-900 py-2",
               :href ""} "Tutorials"]]
          [:li
           [:a
            {:class "flex text-gray-600 hover:text-gray-900 py-2",
             :href "/blog/"} "Blog"]]
          #_[:li {:class "py-2 my-2 border-t border-b border-gray-200"}
             [:span {:class "flex text-gray-600 hover:text-gray-900 py-2"}
              "Resources"]
             [:ul {:class "pl-4"}
              [:li
               [:a
                {:class
                 "text-sm flex font-medium text-gray-600 hover:text-gray-900 py-2",
                 :href "documentation.html"} "Documentation"]]
              [:li
               [:a
                {:class
                 "text-sm flex font-medium text-gray-600 hover:text-gray-900 py-2",
                 :href "support.html"} "Support center"]]
              [:li
               [:a
                {:class
                 "text-sm flex font-medium text-gray-600 hover:text-gray-900 py-2",
                 :href "404.html"} "404"]]]]
          [:li
           [:a
            {:class
             "flex font-medium w-full text-gray-600 hover:text-gray-900 py-2 justify-center",
             :target "_blank"
             :href "https://lambdaisland.com"} "LambdaIsland.com"]]
          [:li
           [:a
            {:class
             "btn-sm text-gray-200 bg-gray-900 hover:bg-gray-800 w-full my-2",
             :href "mailto:contact@gaiwan.co"} [:span "Say hi"]
            [:svg
             {:class
              "w-3 h-3 fill-current text-gray-400 flex-shrink-0 ml-2 -mr-1",
              :viewbox "0 0 12 12",
              :xmlns "http://www.w3.org/2000/svg"}
             [:path
              {:d
               "M11.707 5.293L7 .586 5.586 2l3 3H0v2h8.586l-3 3L7 11.414l4.707-4.707a1 1 0 000-1.414z",
               :fill "#999",
               :fill-rule "nonzero"}]]]]]]]]]]]])
