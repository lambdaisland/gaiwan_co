(ns gaiwan.routes
  (:require [gaiwan.layout :as layout]
            [gaiwan.db :as db]
            [gaiwan.open-graph :as og]
            [gaiwan.home :as home]
            [gaiwan.about :as about]
            [gaiwan.components.blog-list :as blog-list]
            [clojure.java.shell :as sh]
            [clojure.java.io :as io]
            [clojure.edn :as edn]
            [clojure.string :as str])
  (:import (java.time Instant)
           (java.time.format DateTimeFormatter)
           (java.text SimpleDateFormat)))

(defn get-version [_]
  (let [commit (-> (sh/sh "git" "rev-parse" "HEAD") :out str/trim)]
    {:status 200
     :body {:commit commit}
     :view #(:commit %)}))

(defn get-home [_]
  {:status 200
   ;; Make the body plain EDN, this is what you will get if you request JSON/EDN/etc.
   :body {}
   ;; View is a function from EDN to Hiccup (receives the body data)
   :view (fn [data]
           [layout/layout
            (og/social-tags {:image ""})
            [home/body]])})

(defn get-blog [_]
  {:status 200
   :body {:posts @db/posts}
   :view (fn [{:keys [posts]}]
           [layout/layout
            (og/social-tags {:image ""})
            [:div
             (blog-list/section posts)]])})

(defn get-blog-item [request]
  (let [{:keys [slug]} (:path-params request)
        post (first @db/posts)]
    {:status 200
     :body {:slug slug
            :post post}
     :view (fn [{:keys [slug post] :as data}]
             (let [{:keys [meta html]} post]
               [layout/layout
                (og/social-tags {:title "Post title"
                                 :description "Post desc"})
                [:div.sakura
                 [:h1 (:title meta)]
                 [:div.post-meta
                  "Posted on "
                  [:span (.format (java.text.SimpleDateFormat. "MMM dd, yyyy") (:date meta))]
                  " by "
                  [:span (:author meta)]]
                 [:lambdaisland.hiccup/unsafe-html html]]]))}))

(defn routes []
  [["/"
    {:name :home
     :get {:handler get-home}}]
   ["/blog"
    {:name :blog
     :get {:handler get-blog}
     :freeze-data-fn (fn []
                       [])}]
   ["/blog/:slug"
    {:name :blog-item
     :get {:handler get-blog-item}
     :freeze-data-fn (fn []
                       (map #(assoc {} :slug (get-in % [:meta :slug] "")) @db/posts))}]
   ["/version"
    {:name :version
     :get {:handler get-version}}]])
