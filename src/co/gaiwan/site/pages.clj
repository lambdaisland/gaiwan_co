(ns co.gaiwan.site.pages
  (:require [clojure.java.shell :as sh]
            [clojure.string :as str]
            [co.gaiwan.site.layout :as layout]
            [co.gaiwan.site.open-graph :as og]
            [lambdaisland.ornament :as o]))

;; (def pages (delay (md-files/slurp-dir "pages")))

(o/defstyled page-wrapper :div
  :my-8 :px-2 :mx-auto)

(defn get-generic [{:nuzzle/keys [render-content] :as page}]
  (layout/layout
   (og/social-tags page)
   (page-wrapper {:class "container prose lg:prose-lg"} (render-content))))

(defn get-version [_page]
  [:html (-> (sh/sh "git" "rev-parse" "HEAD") :out str/trim)])
