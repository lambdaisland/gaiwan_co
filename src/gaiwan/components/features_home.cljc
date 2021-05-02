[:html
 [:body
  [:section {:class "relative"}
   #_[:comment
      " Section background (needs .relative class on parent and next sibling elements) "]
   [:div
    {:aria-hidden "true",
     :class "absolute inset-0 bg-gray-100 pointer-events-none mb-16"}]
   [:div
    {:class
       "absolute left-0 right-0 m-auto w-px p-px h-20 bg-gray-200 transform -translate-y-1/2"}]
   [:div {:class "relative max-w-6xl mx-auto px-4 sm:px-6"}
    [:div {:class "pt-12 md:pt-20"} #_[:comment " Section header "]
     [:div {:class "max-w-3xl mx-auto text-center pb-12 md:pb-16"}
      [:h1 {:class "h2 mb-4"} "How Gaiwan works"]
      [:p {:class "text-xl text-gray-600"}
       "Our job is to find a path from a business need to a technical solution that is simple, effective, and on-time"]]
     #_[:comment " Top image "]
     [:div {:class "pb-12 md:pb-16"}
      [:img
       {:alt "Features top",
        :height "325",
        :src "../images/features-top-image.png",
        :width "1104"}]] #_[:comment " Section content "]
     [:div {:class "md:grid md:grid-cols-12 md:gap-6", :x-data "{ tab: '1' }"}
      #_[:comment " Content "]
      [:div
       {:class
          "max-w-xl md:max-w-none md:w-full mx-auto md:col-span-7 lg:col-span-6 md:mt-6"}
       [:div {:class "md:pr-4 lg:pr-12 xl:pr-16 mb-8"}
        [:h3 {:class "h3 mb-3"} "Powerful suite of tools"]
        [:p {:class "text-xl text-gray-600"}
         "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa."]]
       #_[:comment " Tabs buttons "]
       [:div {:class "mb-8 md:mb-0"}
        [:a
         {:class
            "flex items-center text-lg p-5 rounded border transition duration-300 ease-in-out mb-3",
          ::class
            "tab !== '1' ? 'bg-white shadow-md border-gray-200 hover:shadow-lg' : 'bg-gray-200 border-transparent'",
          :href "#0"}
         [:div
          [:div {:class "font-bold leading-snug tracking-tight mb-1"}
           "Building the Simple ecosystem"]
          [:div {:class "text-gray-600"}
           "Take collaboration to the next level with security and administrative features built for teams."]]
         [:div
          {:class
             "flex justify-center items-center w-8 h-8 bg-white rounded-full shadow flex-shrink-0 ml-3"}
          [:svg
           {:class "w-3 h-3 fill-current",
            :viewbox "0 0 12 12",
            :xmlns "http://www.w3.org/2000/svg"}
           [:path
            {:d
               "M11.953 4.29a.5.5 0 00-.454-.292H6.14L6.984.62A.5.5 0 006.12.173l-6 7a.5.5 0 00.379.825h5.359l-.844 3.38a.5.5 0 00.864.445l6-7a.5.5 0 00.075-.534z"}]]]]
        [:a
         {:class
            "flex items-center text-lg p-5 rounded border transition duration-300 ease-in-out mb-3",
          ::class
            "tab !== '2' ? 'bg-white shadow-md border-gray-200 hover:shadow-lg' : 'bg-gray-200 border-transparent'",
          :href "#0"}
         [:div
          [:div {:class "font-bold leading-snug tracking-tight mb-1"}
           "Building the Simple ecosystem"]
          [:div {:class "text-gray-600"}
           "Take collaboration to the next level with security and administrative features built for teams."]]
         [:div
          {:class
             "flex justify-center items-center w-8 h-8 bg-white rounded-full shadow flex-shrink-0 ml-3"}
          [:svg
           {:class "w-3 h-3 fill-current",
            :viewbox "0 0 12 12",
            :xmlns "http://www.w3.org/2000/svg"}
           [:path
            {:d
               "M11.854.146a.5.5 0 00-.525-.116l-11 4a.5.5 0 00-.015.934l4.8 1.921 1.921 4.8A.5.5 0 007.5 12h.008a.5.5 0 00.462-.329l4-11a.5.5 0 00-.116-.525z",
             :fill-rule "nonzero"}]]]]
        [:a
         {:class
            "flex items-center text-lg p-5 rounded border transition duration-300 ease-in-out",
          ::class
            "tab !== '3' ? 'bg-white shadow-md border-gray-200 hover:shadow-lg' : 'bg-gray-200 border-transparent'",
          :href "#0"}
         [:div
          [:div {:class "font-bold leading-snug tracking-tight mb-1"}
           "Building the Simple ecosystem"]
          [:div {:class "text-gray-600"}
           "Take collaboration to the next level with security and administrative features built for teams."]]
         [:div
          {:class
             "flex justify-center items-center w-8 h-8 bg-white rounded-full shadow flex-shrink-0 ml-3"}
          [:svg
           {:class "w-3 h-3 fill-current",
            :viewbox "0 0 12 12",
            :xmlns "http://www.w3.org/2000/svg"}
           [:path
            {:d
               "M11.334 8.06a.5.5 0 00-.421-.237 6.023 6.023 0 01-5.905-6c0-.41.042-.82.125-1.221a.5.5 0 00-.614-.586 6 6 0 106.832 8.529.5.5 0 00-.017-.485z",
             :fill "#191919",
             :fill-rule "nonzero"}]]]]]] #_[:comment " Tabs items "]
      [:div
       {:class
          "max-w-xl md:max-w-none md:w-full mx-auto md:col-span-5 lg:col-span-6 mb-8 md:mb-0 md:order-1",
        :data-aos "zoom-y-out"}
       [:div {:class "relative flex flex-col text-center lg:text-right"}
        #_[:comment " Item 1 "]
        [:div
         {:class "w-full",
          :x-show "tab === '1'",
          :x-transition:enter
            "transition ease-in-out duration-700 transform order-first",
          :x-transition:enter-end "opacity-100 translate-y-0",
          :x-transition:enter-start "opacity-0 translate-y-16",
          :x-transition:leave
            "transition ease-in-out duration-300 transform absolute",
          :x-transition:leave-end "opacity-0 -translate-y-16",
          :x-transition:leave-start "opacity-100 translate-y-0"}
         [:div {:class "relative inline-flex flex-col"}
          [:img
           {:alt "Features bg",
            :class "md:max-w-none mx-auto rounded",
            :height "375",
            :src "../images/features-home-bg-01.png",
            :width "500"}]
          [:img
           {:alt "Element 01",
            :class
              "md:max-w-none absolute w-full left-0 transform animate-float",
            :height "147",
            :src "../images/features-home-element-01.png",
            :style "top:22%",
            :width "500"}]
          [:img
           {:alt "Element 02",
            :class
              "md:max-w-none absolute w-full left-0 transform animate-float animation-delay-500",
            :height "158",
            :src "../images/features-home-element-02.png",
            :style "top:39%",
            :width "500"}]
          [:img
           {:alt "Element 03",
            :class
              "md:max-w-none absolute w-full left-0 bottom-0 transform animate-float animation-delay-1000",
            :height "167",
            :src "../images/features-home-element-03.png",
            :style "top:77%",
            :width "500"}]]] #_[:comment " Item 2 "]
        [:div
         {:class "w-full",
          :x-show "tab === '2'",
          :x-transition:enter
            "transition ease-in-out duration-700 transform order-first",
          :x-transition:enter-end "opacity-100 translate-y-0",
          :x-transition:enter-start "opacity-0 translate-y-16",
          :x-transition:leave
            "transition ease-in-out duration-300 transform absolute",
          :x-transition:leave-end "opacity-0 -translate-y-16",
          :x-transition:leave-start "opacity-100 translate-y-0"}
         [:div {:class "relative inline-flex flex-col"}
          [:img
           {:alt "Features bg",
            :class "md:max-w-none mx-auto rounded",
            :height "375",
            :src "../images/features-home-bg-01.png",
            :width "500"}]
          [:img
           {:alt "Element 03",
            :class
              "md:max-w-none absolute w-full left-0 bottom-0 transform animate-float animation-delay-1000",
            :height "167",
            :src "../images/features-home-element-03.png",
            :style "top:18%",
            :width "500"}]
          [:img
           {:alt "Element 02",
            :class
              "md:max-w-none absolute w-full left-0 transform animate-float animation-delay-500",
            :height "158",
            :src "../images/features-home-element-02.png",
            :style "top:40%",
            :width "500"}]
          [:img
           {:alt "Element 01",
            :class
              "md:max-w-none absolute w-full left-0 transform animate-float",
            :height "147",
            :src "../images/features-home-element-01.png",
            :style "top:79%",
            :width "500"}]]] #_[:comment " Item 3 "]
        [:div
         {:class "w-full",
          :x-show "tab === '3'",
          :x-transition:enter
            "transition ease-in-out duration-700 transform order-first",
          :x-transition:enter-end "opacity-100 translate-y-0",
          :x-transition:enter-start "opacity-0 translate-y-16",
          :x-transition:leave
            "transition ease-in-out duration-300 transform absolute",
          :x-transition:leave-end "opacity-0 -translate-y-16",
          :x-transition:leave-start "opacity-100 translate-y-0"}
         [:div {:class "relative inline-flex flex-col"}
          [:img
           {:alt "Features bg",
            :class "md:max-w-none mx-auto rounded",
            :height "375",
            :src "../images/features-home-bg-01.png",
            :width "500"}]
          [:img
           {:alt "Element 01",
            :class
              "md:max-w-none absolute w-full left-0 transform animate-float",
            :height "147",
            :src "../images/features-home-element-01.png",
            :style "top:22%",
            :width "500"}]
          [:img
           {:alt "Element 02",
            :class
              "md:max-w-none absolute w-full left-0 transform animate-float animation-delay-500",
            :height "158",
            :src "../images/features-home-element-02.png",
            :style "top:39%",
            :width "500"}]
          [:img
           {:alt "Element 03",
            :class
              "md:max-w-none absolute w-full left-0 bottom-0 transform animate-float animation-delay-1000",
            :height "167",
            :src "../images/features-home-element-03.png",
            :style "top:77%",
            :width "500"}]]]]]]]]]]]
