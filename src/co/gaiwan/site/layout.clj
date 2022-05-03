(ns co.gaiwan.site.layout
  (:require [clojure.java.io :as io]
            [clojure.data.json :as json]
            [co.gaiwan.site.components.header :as header]
            [co.gaiwan.site.components.footer :as footer]
            [lambdaisland.ornament :as ornament]))

(defn get-script-name
  "Read the manifest.edn file, and get the current main.HASHCODE.js filename
   (get-script-name :main) => main.HASHCODE.js "
  [module-id-k]
  (some->> (io/resource "assets/ui/manifest.edn")
           slurp
           read-string
           (filter #(= module-id-k (:module-id %)))
           first
           :output-name))

(def matamo-analytics-script
  [:script {:type "text/javascript"}
   "var _paq = window._paq || [];
   _paq.push(['trackPageView']);
   _paq.push(['enableLinkTracking']);
   (function() {
     var u='//analytics.arnebrasseur.net/';
     _paq.push(['setTrackerUrl', u+'matomo.php']);
     _paq.push(['setSiteId', '2']);
     var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0];
     g.type='text/javascript'; g.async=true; g.defer=true; g.src=u+'matomo.js'; s.parentNode.insertBefore(g,s);
     })();"])

(def navbar
  [:header.top-navbar
   [:a.secondary-font.top-navbar__brand {:href "/"} "Gaiwan"]])

(defn layout
  ([body]
   [layout nil body])
  ([head body]
   [:html
    [:head
     [:meta {:charset "UTF-8"}]
     [:meta {:content "width=device-width, initial-scale=1" :name "viewport"}]
     [:link {:href "/assets/css/main.css", :rel "stylesheet"}]
     [:link {:href "/assets/css/sakura-ink-embed.css", :rel "stylesheet"}]
     [:link {:href "/assets/css/style.css", :rel "stylesheet"}]
     [:link {:href "/assets/css/ornament.css", :rel "stylesheet"}]
     [:link {:rel "icon" :href "/favicon.ico" :type "image/png"}]
     [:link {:rel "apple-touch-icon" :sizes "180x180" :href "/apple-touch-icon.png"}]
     [:link {:rel "icon" :type "image/png" :sizes "32x32" :href "/favicon-32x32.png"}]
     [:link {:rel "icon" :type "image/png" :sizes "16x16" :href "/favicon-16x16.png"}]
     [:link {:rel "manifest" :href "/site.webmanifest"}]
     matamo-analytics-script
     [:link {:href "https://use.typekit.net/oxk2nmu.css", :rel "stylesheet"}]
     #_(if (io/resource "assets/css/ornament.css")
         [:link {:rel "stylesheet" :href "/assets/css/ornament.css"}]
         [:style {:type "text/css" :id "ornament"}
          (ornament/defined-styles {:preflight? true})])
     [:link {:rel "alternate" :type "application/rss+xml" :title "RSS Feed for the Gaiwan Blog" :href "/blog.xml"}]
     head]
    [:body
     {:class "font-inter antialiased bg-white text-gray-900 tracking-tight"}
     (header/top)
     [:main {:class "flex-grow"}
      body]
     (footer/footer)
     [:script {:type "application/javascript" :src (str "/assets/ui/" (get-script-name :main))}]]]))
