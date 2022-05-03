(ns co.gaiwan.site
  (:require [clojure.java.io :as io]
            [co.gaiwan.site.http :as http]
            [lambdaisland.reitit-jaatya.freeze :as freeze]
            [lambdaisland.webstuff.bootstrap :as bootstrap]))

(defn build [& args]
  (http/spit-ornament)
  (freeze/iced
   (http/build-handler)
   {:sitemap-path "/sitemap.xml"
    :sitemap-trailing-slash true
    :base-url "https://gaiwan.co"}))

(defn serve []
  (bootstrap/go :dev))

(comment
  ;; this will create a `_site` folder in `does-library`
  ;; to browse it locally run
  ;; cd _site && python3 -m http.server
  (build))
