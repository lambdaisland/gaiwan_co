(ns co.gaiwan.site
  (:require [co.gaiwan.site.http :as http]
            [clojure.java.io :as io]
            [lambdaisland.ornament :as ornament]
            [lambdaisland.reitit-jaatya.freeze :as freeze]))

(defn build [& args]
  #_(let [css-file "resources/assets/css/ornament.css"]
      (io/make-parents css-file)
      (spit css-file (ornament/defined-styles {:preflight? true})))
  (freeze/iced
   (http/build-handler)
   {:sitemap-path "/sitemap.xml"
    :sitemap-trailing-slash true
    :base-url "https://gaiwan.co"}))

(comment
  ;; this will create a `_site` folder in `does-library`
  ;; to browse it locally run
  ;; cd _site && python3 -m http.server
  (build))
