(ns gaiwan.common)

(defn gen-head [& {:keys [title description] :or
                   {title "Gaiwan - a Clojure Consultancy"
                    description "Home for Gaiwan, a provider of technological expertise grown out of the consulting and development work of Lambda Island's Arne Brasseur"}}]
  [:head
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
   [:title title]
   [:meta {:charset "utf-8"}]
   [:meta {:name "Description", :content description}]
   [:link {:href "https://use.typekit.net/oxk2nmu.css", :rel "stylesheet"}]
   [:link {:href "css/main.css", :rel "stylesheet"}]])

(def footer
  [:footer
   [:address
    [:div
     [:p "Gaiwan GmbHKinzigstr. 26- 10247 - Berlin, Germany"] ""]
    [:p "HRB 204912"]
    [:p "VAT ID: DE323279720"]
    [:p "Get in touch: "
     [:a {:class "footer-email", :href "email:contact@gaiwan.co"} "contact@gaiwan.co"]]]])
