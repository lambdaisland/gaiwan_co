(ns gaiwan.blog
  (:require [gaiwan.common :as common]
            [gaiwan.utils :as utils]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [markdown.core :as m]
            [hiccup.core :as hc])
  (:import [java.io StringWriter]))

(defn- get-files []
  (filter
   #(str/ends-with? (.getName %) ".md")
   (file-seq (io/file (io/resource "posts")))))

(defn markdown [input]
  (let [output (new StringWriter)
        metadata (m/md-to-html input output :parse-meta? true)
        html     (.toString output)
        meta (if (nil? (:slug metadata))
               (assoc metadata :slug (utils/slugify (:title metadata)))
               metadata)]
    {:meta meta :html html}))

(defn get-posts []
  (mapv markdown (get-files)))

(def post-list
  [:ul
   (for [post (get-posts)]
     [:li
      [:a {:href (str "/blog/" (get-in post [:meta :slug]) "/")} (get-in post [:meta :title])]])])

(def body
  [:body
   [:main
    [:h2 "Blog posts"]
    post-list]
   common/footer])

(defn blog-page [content]
  [:html (common/gen-head) body])

(defn blog-post [post]
  [:html {:style "font-size: 62.5%;"} (common/gen-head)
   [:div.sakura.post
    [:h1 (get-in post [:meta :title])]
    (:html post)]])