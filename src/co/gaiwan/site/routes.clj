(ns co.gaiwan.site.routes
  (:require [co.gaiwan.site.layout :as layout]
            [co.gaiwan.site.db :as db]
            [co.gaiwan.site.open-graph :as og]
            [co.gaiwan.site.home :as home]
            [co.gaiwan.site.about :as about]
            [co.gaiwan.site.work :as work]
            [co.gaiwan.site.components.blog-list :as blog-list]
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
   :body {:posts (vals @db/posts)}
   :view (fn [{:keys [posts]}]
           [layout/layout
            (og/social-tags {:image ""})
            [:div
             (blog-list/section posts)]])})

(defn get-blog-item [request]
  (let [{:keys [slug]} (:path-params request)
        post (get @db/posts slug)]
    {:status 200
     :body {:slug slug
            :post post}
     :view (fn [{:keys [slug post] :as data}]
             (let [{:keys [meta html]} post]
               [layout/layout
                (og/social-tags {:title (:title meta)
                                 :description ""})
                [:div {:class "post my-8 mx-auto px-2 container prose lg:prose-lg"}
                 [:h1 (:title meta)]
                 [:div.post-meta
                  "Posted on "
                  [:span (.format (java.text.SimpleDateFormat. "MMM dd, yyyy") (:date meta))]
                  " by "
                  [:span (:author meta)]]
                 [:lambdaisland.hiccup/unsafe-html html]]]))}))

(defn get-work [_]
  {:status 200
   :body {}
   :view (fn [_]
           [layout/layout
            (og/social-tags {:title "Our Work - Gaiwan Team"
                             :description "Projects built by the Gaiwan team.
                             We use clojure and clojurescript to solve critical
                             problems for our clients."})
            [work/body]])})

(defn routes []
  [["/"
    {:name :home
     :get {:handler get-home}}]
   ["/blog"
    {:name :blog
     :get {:handler get-blog}}]
   ["/blog/:slug"
    {:name :blog-item
     :get {:handler get-blog-item}
     :freeze-data-fn (fn []
                       (map #(assoc {} :slug (get-in % [:meta :slug] "")) (vals @db/posts)))}]
   ["/work"
    {:name :work
     :get {:handler get-work}}]
   ["/version"
    {:name :version
     :get {:handler get-version}}]])