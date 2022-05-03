(ns co.gaiwan.site.http
  (:require [co.gaiwan.site.routes :as routes]
            [clojure.java.io :as io]
            [integrant.core :as ig]
            [lambdaisland.ornament :as ornament]
            [lambdaisland.webstuff.bootstrap :as bootstrap]
            [lambdaisland.webstuff.http :as http]
            [reitit.ring :as ring]
            [ring.middleware.resource :as resource]))

(bootstrap/set-config! "config.edn")

(defn default-handler []
  (ring/routes
   (ring/create-resource-handler {:path "/assets" :root "assets"})
   (ring/redirect-trailing-slash-handler {:method :strip})
   (ring/create-default-handler nil)))

(defn spit-ornament []
  (let [css-file "resources/assets/css/ornament.css"]
    (io/make-parents css-file)
    (spit css-file (ornament/defined-styles #_{:preflight? true}))))

(defn wrap-spit-ornament [f]
  (fn [req]
    (spit-ornament)
    (f req)))

(defn build-handler []
  (http/ring-handler {:routes (routes/routes)
                      :middleware [[resource/wrap-resource ""]]
                      :default-handler (default-handler)}))

(defmethod ig/init-key ::server [_ {:keys [port rebuild-on-request?] :as config}]
  (http/start-jetty! (assoc config :build-handler (comp wrap-spit-ornament #'build-handler))))

(defmethod ig/halt-key! ::server [_ jetty]
  (http/stop-jetty! jetty))

(defn -main [& [profile]]
  (let [profile (or profile "dev")]
    (bootstrap/go (keyword profile)))
  @(promise))
