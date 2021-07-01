(ns gaiwan.components.faq)

(defn item [faq]
  {})

(defn list [faqs]
  [:div {:class "bg-gray-50"}
   [:div {:class "max-w-7xl mx-auto py-12 px-4 sm:py-16 sm:px-6 lg:px-8"}
    [:div {:class "max-w-3xl mx-auto divide-y-2 divide-gray-200"}
     [:h2
      {:class "text-center text-3xl font-extrabold text-gray-900 sm:text-4xl"}
      "Frequently asked questions"]
     [:dl {:class "mt-6 space-y-6 divide-y divide-gray-200"}
      [:div {:class "pt-6"}
       [:dt {:class "text-lg"}
        [:button
         {:aria-controls "faq-0",
          :aria-expanded "false",
          :class
          "text-left w-full flex justify-between items-start text-gray-400",
          :type "button"}
         [:span {:class "font-medium text-gray-900"}
          "What's the best thing about Switzerland?"]]]
       [:dd#faq-0 {:class "mt-2 pr-12"}
        [:p {:class "text-base text-gray-500"}
         "I don't know, but the flag is a big plus. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas cupiditate laboriosam fugiat."]]]]]]])
