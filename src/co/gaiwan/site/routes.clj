(ns co.gaiwan.site.routes
  (:require [clojure.java.shell :as sh]
            [clojure.string :as str]
            [co.gaiwan.site.blog :as blog]
            [co.gaiwan.site.home :as home]
            [co.gaiwan.site.pages :as pages]
            [co.gaiwan.site.layout :as layout]
            [co.gaiwan.site.open-graph :as og]
            [co.gaiwan.site.work :as work]))

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

(defn get-talk-to-us [_]
  {:status 200
   :body {:redirect-to "https://calendly.com/gaiwanteam/30min"}
   :view (fn [{:keys [redirect-to]}]
           [:html {:lang "en"}
            [:head [:meta {:charset "utf-8"}]
             [:meta {:http-equiv "refresh" :content (str "0;url=" redirect-to)}]
             [:link {:rel "canonical" :href redirect-to}]]
            [:body
             [:p "You are being redirected to "
              [:a {:href redirect-to} redirect-to]]]])})

(defn routes []
  (into
   [["/"
     {:name :home
      :get {:handler get-home}}]
    ["/blog"
     {:name :blog
      :get {:handler blog/get-blog}}]
    ["/blog.xml"
     {:name :blog-rss
      :get {:handler blog/get-blog-rss}
      :freeze-content-type :xml}]
    ["/blog/:slug"
     {:name :blog-item
      :get {:handler blog/get-blog-item}
      :freeze-data-fn blog/freeze-data}]
    ["/work"
     {:name :work
      :get {:handler get-work}}]
    ["/version"
     {:name :version
      :get {:handler get-version}}]
    ["/talk-to-us"
     {:name :talk-to-us
      :get {:handler get-talk-to-us}}]]
   (pages/routes)))
