(ns gaiwan.components.team)

(defn item [{:keys [title subtitle image description] :as member}]
  [:li
   [:div
    {:class "space-y-4 sm:grid sm:grid-cols-3 sm:gap-6 sm:space-y-0 lg:gap-8"}
    [:div {:class "h-0 aspect-w-3 aspect-h-2 sm:aspect-w-3 sm:aspect-h-4"}
     [:img
      {:alt "",
       :class "object-cover shadow-lg rounded-lg",
       :src
       (if image
         image
         "https://images.unsplash.com/photo-1517365830460-955ce3ccd263?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=8&w=1024&h=1024&q=80")}]]
    [:div {:class "sm:col-span-2"}
     [:div {:class "space-y-4"}
      [:div {:class "text-lg leading-6 font-medium space-y-1"}
       [:h3 title]
       [:p {:class "text-indigo-600"} subtitle]]
      [:div {:class "text-sm"}
       (into
        [:div {:class "text-gray-700 flex flex-col gap-y-1"}]
        description)]]]]])

(defn section [members]
  [:div#team {:class "bg-white"}
   [:div {:class "mx-auto py-12 px-4 max-w-7xl sm:px-6 lg:px-8"}
    [:div {:class "space-y-12"}
     [:h2 {:class "text-3xl font-extrabold tracking-tight sm:text-4xl"}
      "Meet the Gaiwan team"]
     [:ul
      {:class
       "space-y-12 lg:grid lg:grid-cols-2 lg:items-start lg:gap-x-8 lg:gap-y-12 lg:space-y-0"}
      (map item (into [(first members)] (shuffle (rest members))))
      ]]]])
