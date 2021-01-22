(ns gaiwan.blog
  (:require [gaiwan.common :as common]))

(def body
  [:body
   [:main
    [:h2 "Blog posts"]]
   common/footer])

(defn blog-page [content]
  [:html (common/gen-head) body])

