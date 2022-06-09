(ns co.gaiwan.site.blog
  (:require [clj-rss.core :as rss]
            [co.gaiwan.site.layout :as layout]
            [co.gaiwan.site.md-files :as md-files]
            [co.gaiwan.site.open-graph :as og]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Components

(defn list-item [{:keys [html]
                  {:keys [title slug author date] :or {slug ""}} :meta
                  :as post}]
  [:article {:class "flex items-center py-4 border-b border-gray-200"}
   [:div
    [:header
     [:h2 {:class "h4 mb-2"}
      [:a {:class "hover:underline" :href (str "/blog/" slug "/")}
       title]]]
    [:div {:class "text-lg text-gray-600 mb-4"} ""]
    [:footer {:class "text-sm"}
     [:div {:class "flex items-center"}
      [:div [:span {:class "text-gray-600"} "By "]
       [:span {:class "text-gray-600 font-medium hover:underline2"}
        author]
       " "
       [:span {:class "text-gray-600"} (.format (java.text.SimpleDateFormat. "MMM dd, yyyy") date)]]]]]
   [:a {:class "block flex-shrink-0 ml-6" :href (str "/blog/" slug "/")}
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
         [list-item post])]
      [sidebar]]]]])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Routes

(def posts (delay (md-files/slurp-dir "blog")))

(defn get-blog-rss [_]
  {:status 200
   :body (apply rss/channel-xml
                {:title "Gaiwan Blog" :link "https://gaiwan.co/blog" :description "The Gaiwan Blog"}
                (for [{:keys [meta html]} (vals @posts)
                      :let [{:keys [title slug author date]} meta]]
                  {:title title
                   :link (str "https://gaiwan.co/blog/" slug)
                   :description html
                   :author author
                   :pubDate (.toInstant date)}))})

(defn get-blog-item [request]
  (let [{:keys [slug]} (:path-params request)
        post (get @posts slug)]
    {:status 200
     :body {:slug slug
            :post post}
     :view (fn [{:keys [slug post] :as data}]
             (let [{:keys [meta hiccup]} post]
               [layout/layout
                (og/social-tags {:title (:title meta)
                                 :description (:description meta "")})
                [:div {:class "post my-8 mx-auto px-2 container prose lg:prose-lg"}
                 [:h1 (:title meta)]
                 [:div.post-meta
                  "Posted on "
                  [:span (.format (java.text.SimpleDateFormat. "MMM dd, yyyy") (:date meta))]
                  " by "
                  [:span (:author meta)]]
                 hiccup]]))}))

(defn get-blog [_]
  {:status 200
   :body {:posts (reverse (sort-by (comp :date :meta) (vals @posts)))}
   :view (fn [{:keys [posts]}]
           [layout/layout
            (og/social-tags {:image ""})
            [:div
             (section posts)]])})

(defn freeze-data []
  (map #(do {:slug %}) (keys @posts)))
