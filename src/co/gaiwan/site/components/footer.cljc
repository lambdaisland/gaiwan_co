(ns co.gaiwan.site.components.footer
  (:require [co.gaiwan.site.components.logo :as logo]))

(defn footer []
  [:footer
   [:div {:class "max-w-6xl mx-auto px-4 sm:px-6"}
    #_[:comment " Top area: Blocks "]
    [:div
     {:class
      "grid sm:grid-cols-12 gap-8 py-8 md:py-12 border-t border-gray-200"}
     #_[:comment " 1st block "]
     [:div {:class "sm:col-span-12 lg:col-span-3"}
      (logo/gaiwan-semibold "w-28")
      #_[:div {:class "text-sm text-gray-600"}
         [:a
          {:class
           "text-gray-600 hover:text-gray-900 transition duration-150 ease-in-out",
           :href "#0"} "Terms"] " · "
         [:a
          {:class
           "text-gray-600 hover:text-gray-900 transition duration-150 ease-in-out",
           :href "#0"} "Privacy Policy"]]] #_[:comment " 2nd block "]
     [:div {:class "sm:col-span-6 md:col-span-3 lg:col-span-2"}
      [:h6 {:class "text-gray-800 font-medium mb-2"} "Our projects"]
      [:ul {:class "text-sm"}
       [:li {:class "mb-2"}
        [:a
         {:class
          "text-gray-600 hover:text-gray-900 transition duration-150 ease-in-out",
          :href "https://lambdaisland.com/"} "Lambda Island"]]
       [:li {:class "mb-2"}
        [:a
         {:class
          "text-gray-600 hover:text-gray-900 transition duration-150 ease-in-out",
          :href "https://github.com/lambdaisland/"} "Lambda Island OSS"]]
       [:li {:class "mb-2"}
        [:a
         {:class
          "text-gray-600 hover:text-gray-900 transition duration-150 ease-in-out",
          :href "https://heartofclojure.eu/"} "Heart of Clojure"]]
       [:li {:class "mb-2"}
        [:a
         {:class
          "text-gray-600 hover:text-gray-900 transition duration-150 ease-in-out",
          :href "https://clojureverse.org"} "Clojureverse"]]]] #_[:comment " 3rd block "]
     [:div {:class "sm:col-span-6 md:col-span-3 lg:col-span-2"}
      [:h6 {:class "text-gray-800 font-medium mb-2"} "Open source"]
      [:ul {:class "text-sm"}
       [:li {:class "mb-2"}
        [:a
         {:class
          "text-gray-600 hover:text-gray-900 transition duration-150 ease-in-out",
          :href "https://github.com/lambdaisland/kaocha"} "Kaocha"]]
       [:li {:class "mb-2"}
        [:a
         {:class
          "text-gray-600 hover:text-gray-900 transition duration-150 ease-in-out",
          :href "https://github.com/lambdaisland/deep-diff2"} "Deep diff 2"]]
       [:li {:class "mb-2"}
        [:a
         {:class
          "text-gray-600 hover:text-gray-900 transition duration-150 ease-in-out",
          :href "https://github.com/lambdaisland/regal"} "regal"]]
       [:li {:class "mb-2"}
        [:a
         {:class
          "text-gray-600 hover:text-gray-900 transition duration-150 ease-in-out",
          :href "https://github.com/lambdaisland/uri"} "uri"]]]]
     #_[:comment " 4th block "]
     [:div {:class "sm:col-span-6 md:col-span-3 lg:col-span-2"}
      [:h6 {:class "text-gray-800 font-medium mb-2"} "Company"]
      [:ul {:class "text-sm"}
       (for [[link caption] [["/" "Home"]
                             ;; ["/About/" "About us"]
                             ["https://gaiwan.notion.site/Gaiwan-Strategic-Objective-d40123054382433fb75422b77cc4b25e" "Company objectives"]
                             ["https://gaiwan.notion.site/Gaiwan-operating-principles-3f74a7fd1ee2425eb918879fc55dbfb8" "Company values"]
                             #_["https://gaiwan.co/assets/imgs/Gaiwan-logo-transparent-bg.png" "Logo transparent"]
                             #_["https://gaiwan.co/assets/imgs/Gaiwan-logo-white-bg-with-border.png" "Logo white"]]]
         [:li {:class "mb-2"}
          [:a {:class "text-gray-600 hover:text-gray-900 transition duration-150 ease-in-out" :href link}
           caption]])]]
     #_[:comment " 5th block "]
     [:div {:class "sm:col-span-6 md:col-span-3 lg:col-span-3"}
      [:h6 {:class "text-gray-800 font-medium mb-2"} "Subscribe"]
      [:p {:class "text-sm text-gray-600 mb-4"}
       "Get the latest news and articles to your inbox every month."]
      [:form {:action "https://tinyletter.com/gaiwanteam" :method "post"}
       [:div {:class "flex flex-wrap mb-4"}
        [:div {:class "w-full"}
         [:label {:class "block text-sm sr-only", :for "newsletter"} "Email"]
         [:div {:class "relative flex items-center max-w-xs"}
          [:input#newsletter
           {:class "form-input w-full text-gray-800 px-3 py-2 pr-12 text-sm",
            :placeholder "Your email",
            :name "email"
            :type "email"}]
          [:button
           {:aria-label "Subscribe",
            :class "absolute inset-0 left-auto",
            :type "submit"}
           [:span
            {:aria-hidden "true",
             :class "absolute inset-0 right-auto w-px -ml-px my-2 bg-gray-300"}]
           [:svg
            {:class "w-3 h-3 fill-current text-blue-600 mx-3 flex-shrink-0",
             :viewbox "0 0 12 12",
             :xmlns "http://www.w3.org/2000/svg"}
            [:path
             {:d
              "M11.707 5.293L7 .586 5.586 2l3 3H0v2h8.586l-3 3L7 11.414l4.707-4.707a1 1 0 000-1.414z",
              :fill-rule "nonzero"}]]]] #_[:comment " Success message "]
         #_[:comment
            " <p class=\"mt-2 text-green-600 text-sm\">Thanks for subscribing!</p> "]]]]]]
    #_[:comment " Bottom area "]
    [:div
     {:class
      "md:flex md:items-center md:justify-between py-4 md:py-8 border-t border-gray-200"}
     #_[:comment " Social links "]
     [:ul {:class "flex mb-4 md:order-1 md:ml-4 md:mb-0"}
      [:li
       [:a
        {:aria-label "Twitter",
         :class
         "flex justify-center items-center text-gray-600 hover:text-gray-900 bg-white hover:bg-white-100 rounded-full shadow transition duration-150 ease-in-out",
         :href "https://twitter.com/lambdaisland"}
        [:svg
         {:class "w-8 h-8 fill-current",
          :viewbox "0 0 32 32",
          :xmlns "http://www.w3.org/2000/svg"}
         [:path
          {:d
           "M24 11.5c-.6.3-1.2.4-1.9.5.7-.4 1.2-1 1.4-1.8-.6.4-1.3.6-2.1.8-.6-.6-1.5-1-2.4-1-1.7 0-3.2 1.5-3.2 3.3 0 .3 0 .5.1.7-2.7-.1-5.2-1.4-6.8-3.4-.3.5-.4 1-.4 1.7 0 1.1.6 2.1 1.5 2.7-.5 0-1-.2-1.5-.4 0 1.6 1.1 2.9 2.6 3.2-.3.1-.6.1-.9.1-.2 0-.4 0-.6-.1.4 1.3 1.6 2.3 3.1 2.3-1.1.9-2.5 1.4-4.1 1.4H8c1.5.9 3.2 1.5 5 1.5 6 0 9.3-5 9.3-9.3v-.4c.7-.5 1.3-1.1 1.7-1.8z"}]]]]
      [:li {:class "ml-4"}
       [:a
        {:aria-label "Github",
         :class
         "flex justify-center items-center text-gray-600 hover:text-gray-900 bg-white hover:bg-white-100 rounded-full shadow transition duration-150 ease-in-out",
         :href "https://github.com/lambdaisland"}
        [:svg
         {:class "w-8 h-8 fill-current",
          :viewbox "0 0 32 32",
          :xmlns "http://www.w3.org/2000/svg"}
         [:path
          {:d
           "M16 8.2c-4.4 0-8 3.6-8 8 0 3.5 2.3 6.5 5.5 7.6.4.1.5-.2.5-.4V22c-2.2.5-2.7-1-2.7-1-.4-.9-.9-1.2-.9-1.2-.7-.5.1-.5.1-.5.8.1 1.2.8 1.2.8.7 1.3 1.9.9 2.3.7.1-.5.3-.9.5-1.1-1.8-.2-3.6-.9-3.6-4 0-.9.3-1.6.8-2.1-.1-.2-.4-1 .1-2.1 0 0 .7-.2 2.2.8.6-.2 1.3-.3 2-.3s1.4.1 2 .3c1.5-1 2.2-.8 2.2-.8.4 1.1.2 1.9.1 2.1.5.6.8 1.3.8 2.1 0 3.1-1.9 3.7-3.7 3.9.3.4.6.9.6 1.6v2.2c0 .2.1.5.6.4 3.2-1.1 5.5-4.1 5.5-7.6-.1-4.4-3.7-8-8.1-8z"}]]]]
      #_[:li {:class "ml-4"}
         [:a
          {:aria-label "Facebook",
           :class
           "flex justify-center items-center text-gray-600 hover:text-gray-900 bg-white hover:bg-white-100 rounded-full shadow transition duration-150 ease-in-out",
           :href "#0"}
          [:svg
           {:class "w-8 h-8 fill-current",
            :viewbox "0 0 32 32",
            :xmlns "http://www.w3.org/2000/svg"}
           [:path
            {:d
             "M14.023 24L14 17h-3v-3h3v-2c0-2.7 1.672-4 4.08-4 1.153 0 2.144.086 2.433.124v2.821h-1.67c-1.31 0-1.563.623-1.563 1.536V14H21l-1 3h-2.72v7h-3.257z"}]]]]]
     #_[:comment " Copyrights note "]
     [:div {:class "text-sm text-gray-600 mr-4"}
      "© Gaiwan GmbH, Akazienstraße 3A - 10823 Berlin - Germany | HRB 204912 | VAT ID: DE323279720"]]]])
