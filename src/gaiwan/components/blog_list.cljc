(ns gaiwan.components.blog-list)

(defn list-item [{:keys [html]
                  {:keys [title slug author date] :or {slug ""}} :meta
                  :as post}]
  [:article {:class "flex items-center py-4 border-b border-gray-200"}
   [:div
    [:header
     [:h2 {:class "h4 mb-2"}
      [:a {:class "hover:underline", :href (str "/blog/" slug "/")}
       title]]]
    [:div {:class "text-lg text-gray-600 mb-4"}
     "In this post, you will learn how to deploy a blog using Simple custom asset source plugin that uses the webcam to insert a photo in the image field."]
    [:footer {:class "text-sm"}
     [:div {:class "flex items-center"}
      [:div {:class "flex flex-shrink-0 mr-3"}
       [:a {:class "relative", :href "#0"}
        [:span {:aria-hidden "true", :class "absolute inset-0 -m-px"}
         [:span {:class "absolute inset-0 -m-px bg-white rounded-full"}]]
        [:img
         {:alt author
          :class "relative rounded-full",
          :height "32",
          :src "/imgs/pattern.svg",
          :width "32"}]]]
      [:div [:span {:class "text-gray-600"} "By "]
       [:a {:class "font-medium hover:underline", :href "#0"}
        author]
       [:span {:class "text-gray-600"} " · July 20, 2020"]]]]]
   [:a {:class "block flex-shrink-0 ml-6", :href "blog-post.html"}
    [:span {:class "sr-only"} "Read more"]
    [:svg
     {:class "w-4 h-4 fill-current text-blue-600",
      :viewbox "0 0 16 16",
      :xmlns "http://www.w3.org/2000/svg"}
     [:path
      {:d "M9.3 14.7l-1.4-1.4L12.2 9H0V7h12.2L7.9 2.7l1.4-1.4L16 8z"}]]]])

(defn sidebar []
  [:aside
   {:class
    "relative mt-12 md:mt-0 md:w-64 md:ml-12 lg:ml-20 md:flex-shrink-0"}
   #_[:comment " Topics "]
   #_[:div
    [:h4 {:class "text-lg font-bold leading-snug tracking-tight mb-4"}
     "Topics"]
    [:ul {:class "-my-2"}
     [:li {:class "flex py-2 border-b border-gray-200"}
      [:svg
       {:class "w-4 h-4 flex-shrink-0 fill-current text-gray-400 mt-1 mr-3",
        :xmlns "http://www.w3.org/2000/svg"}
       [:path
        {:d
         "M2.99 15h2.02l.429-3h3.979l-.428 3h2.02l.429-3H14v-2h-2.275l.575-4H15V4h-2.418l.428-3h-2.02l-.429 3H6.582l.428-3H4.99l-.429 3H2v2h2.275L3.7 10H1v2h2.418l-.428 3zM6.3 6h3.979L9.7 10H5.725L6.3 6z"}]]
      [:div {:class "font-medium mb-1"}
       [:a {:class "hover:underline", :href "#0"} "
News & Updates
"]]]
     [:li {:class "flex py-2 border-b border-gray-200"}
      [:svg
       {:class "w-4 h-4 flex-shrink-0 fill-current text-gray-400 mt-1 mr-3",
        :xmlns "http://www.w3.org/2000/svg"}
       [:path
        {:d
         "M2.99 15h2.02l.429-3h3.979l-.428 3h2.02l.429-3H14v-2h-2.275l.575-4H15V4h-2.418l.428-3h-2.02l-.429 3H6.582l.428-3H4.99l-.429 3H2v2h2.275L3.7 10H1v2h2.418l-.428 3zM6.3 6h3.979L9.7 10H5.725L6.3 6z"}]]
      [:div {:class "font-medium mb-1"}
       [:a {:class "hover:underline", :href "#0"} "
Interviews
"]]]
     [:li {:class "flex py-2 border-b border-gray-200"}
      [:svg
       {:class "w-4 h-4 flex-shrink-0 fill-current text-gray-400 mt-1 mr-3",
        :xmlns "http://www.w3.org/2000/svg"}
       [:path
        {:d
         "M2.99 15h2.02l.429-3h3.979l-.428 3h2.02l.429-3H14v-2h-2.275l.575-4H15V4h-2.418l.428-3h-2.02l-.429 3H6.582l.428-3H4.99l-.429 3H2v2h2.275L3.7 10H1v2h2.418l-.428 3zM6.3 6h3.979L9.7 10H5.725L6.3 6z"}]]
      [:div {:class "font-medium mb-1"}
       [:a {:class "hover:underline", :href "#0"} "
Simple Dev
"]]]
     [:li {:class "flex py-2"}
      [:svg
       {:class "w-4 h-4 flex-shrink-0 fill-current text-gray-400 mt-1 mr-3",
        :xmlns "http://www.w3.org/2000/svg"}
       [:path
        {:d
         "M2.99 15h2.02l.429-3h3.979l-.428 3h2.02l.429-3H14v-2h-2.275l.575-4H15V4h-2.418l.428-3h-2.02l-.429 3H6.582l.428-3H4.99l-.429 3H2v2h2.275L3.7 10H1v2h2.418l-.428 3zM6.3 6h3.979L9.7 10H5.725L6.3 6z"}]]
      [:div {:class "font-medium mb-1"}
       [:a {:class "hover:underline", :href "#0"} "Product"]]]]]])

(defn section [posts]
  [:section
   [:div {:class "max-w-6xl mx-auto px-4 sm:px-6"}
    [:div {:class "pt-24 pb-12 md:pt-32 md:pb-20"}
     #_[:comment " Page header "]
     [:div {:class "max-w-3xl pb-12 md:pb-20 text-center md:text-left"}
      [:h1 {:class "h1 mb-4"} "Let's have a cup of tea"]
      [:p {:class "text-xl text-gray-600"}
       "Learn about clojure, clojurescript, design, MVP's, and business. Also
       get occasional "
       [:s " cat pictures"]
       " updates from the Gaiwan team"
       ]]
     #_[:comment " Main content "]
     [:div {:class "md:flex md:justify-between"}
      #_[:comment " Articles container "]
      [:div {:class "md:flex-grow -mt-4"}
       (for [post posts]
         (list-item post))]
      (sidebar)
      ]]]])
