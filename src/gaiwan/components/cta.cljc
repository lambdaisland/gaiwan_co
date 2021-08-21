(ns gaiwan.components.cta)

(defn section [{:keys [title subtitle link button-text]}]
  [:section
   [:div {:class "max-w-7xl mx-auto px-4 sm:px-6"}
    [:div {:class "pb-12 md:pb-20"}
     [:div
      {:class "bg-gradient-to-br from-blue-600 to-green-400 rounded py-10 px-8 md:py-16 md:px-12 shadow-2xl",
       :data-aos "zoom-y-out"}
      [:div {:class "flex flex-col lg:flex-row justify-between items-center"}
       #_[:comment " CTA content "]
       [:div {:class "mb-6 lg:mr-16 lg:mb-0 text-center lg:text-left"}
        [:h3 {:class "h3 text-white mb-2"}
         title]
        [:div {:class "text-white text-lg opacity-75"}
         subtitle]]
       #_[:comment " CTA button "]
       [:div
        [:a
         {:class "btn text-blue-600 bg-gradient-to-r from-blue-100 to-white",
          :href link} button-text]]]]]]])
