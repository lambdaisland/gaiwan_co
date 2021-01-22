(ns gaiwan.blog
  (:require [gaiwan.common :as common]
            [clojure.java.io :as io]
            [clojure.string :as str]))

(defn get-posts []
  (filter
   #(str/ends-with? (.getName %) ".md")
   (file-seq (io/file (io/resource "posts")))))

(def post-list
  [:ul
   (for [post (get-posts)]
     [:li (.getName post)])])

(def body
  [:body
   [:main
    [:h2 "Blog posts"]
    post-list]
   common/footer])

(defn blog-page [content]
  [:html (common/gen-head) body])

