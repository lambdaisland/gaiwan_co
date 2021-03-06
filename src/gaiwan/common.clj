(ns gaiwan.common)

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

(defn gen-head [& {:keys [title description] :or
                   {title "Gaiwan - a Clojure Consultancy"
                    description "Home for Gaiwan, a provider of technological expertise grown out of the consulting and development work of Lambda Island's Arne Brasseur"}}]
  [:head
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
   [:title title]
   [:meta {:charset "utf-8"}]
   [:meta {:name "Description", :content description}]
   [:link {:href "https://use.typekit.net/oxk2nmu.css", :rel "stylesheet"}]
   [:link {:href "/css/main.css", :rel "stylesheet"}]
   [:link {:href "/css/sakura-ink-embed.css", :rel "stylesheet"}]
   matamo-analytics-script])

(def navbar
  [:header.top-navbar
   [:a.secondary-font.top-navbar__brand {:href "/"} "Gaiwan"]])

(def footer
  [:footer
   [:address
    [:div
     [:p "Gaiwan GmbHKinzigstr. 26- 10247 - Berlin, Germany"] ""]
    [:p "HRB 204912"]
    [:p "VAT ID: DE323279720"]
    [:p "Get in touch: "
     [:a {:class "footer-email", :href "mailto:contact@gaiwan.co"} "contact@gaiwan.co"]]]])
