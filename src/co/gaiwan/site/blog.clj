(ns co.gaiwan.site.blog
  (:require [co.gaiwan.site.layout :as layout]
            [co.gaiwan.site.open-graph :as og]
            [co.gaiwan.site.utils :as utils]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Components

(defn list-item [{:nuzzle/keys [title url author published]}]
  [:article {:class "flex items-center py-4 border-b border-gray-200"}
   [:div
    [:header
     [:h2 {:class "h4 mb-2"}
      [:a {:class "hover:underline" :href url}
       title]]]
    [:div {:class "text-lg text-gray-600 mb-4"} ""]
    [:footer {:class "text-sm"}
     [:div {:class "flex items-center"}
      [:div [:span {:class "text-gray-600"} "By "]
       [:span {:class "text-gray-600 font-medium hover:underline2"}
        (author :name)]
       " "
       [:span {:class "text-gray-600"} (utils/format-inst published)]]]]]
   [:a {:class "block flex-shrink-0 ml-6" :href url}
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
    "relative mt-12 md:mt-0 md:w-64 md:ml-12 lg:ml-20 md:flex-shrink-0"}])

(defn section [{:nuzzle/keys [get-pages] :as _page}]
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
       (for [post (->> (get-pages [:blog] {:children true})
                       (sort-by :nuzzle/published)
                       reverse)]
         (list-item post))]
      (sidebar)]]]])

(defn get-blog-item
  [{:nuzzle/keys [author render-content published] :as page}]
  (layout/layout
   (og/social-tags page)
   [:div {:class "post my-8 mx-auto px-2 container prose lg:prose-lg"}
    [:h1 (:title meta)]
    [:div.post-meta
     "Posted on "
     [:span (utils/format-inst published)]
     " by "
     [:span (let [{:keys [name twitter]} author]
              (str name (when twitter (str " (" twitter ")"))))]]
    (render-content)]))

(defn get-blog [page]
  (layout/layout
   (og/social-tags page)
   [:div
    (section page)]))

