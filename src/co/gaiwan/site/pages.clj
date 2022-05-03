(ns co.gaiwan.site.pages
  (:require [co.gaiwan.site.layout :as layout]
            [co.gaiwan.site.md-files :as md-files]
            [co.gaiwan.site.open-graph :as og]
            [lambdaisland.ornament :as o]))

(def pages (delay (md-files/slurp-dir "pages")))

(o/defstyled page-wrapper :div
  :my-8 :px-2 :mx-auto)

(defn get-page [slug _]
  (let [page (get @pages slug)]
    {:status 200
     :body {:slug slug
            :page page}
     :view (fn [{:keys [slug page] :as data}]
             (let [{:keys [meta hiccup]} page]
               [layout/layout (og/social-tags {:title (:title meta)
                                               :description (:description meta "")})

                [page-wrapper {:class "container prose lg:prose-lg"}
                 hiccup]]))}))

(defn routes []
  (for [slug (keys (md-files/slurp-dir "pages"))]
    {(str "/" slug)
     {:name (keyword slug)
      :get {:handler (partial get-page slug)}}}))
