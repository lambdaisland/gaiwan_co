(ns co.gaiwan.site.utils
  (:require [clojure.java.io :as io]
            [lambdaisland.ornament :as ornament])
  (:import java.time.format.DateTimeFormatter
           java.time.ZoneId
           java.util.Locale))

;; (defn slugify
;;   [string]
;;   ((comp #(clojure.string/replace % #" " "-")
;;          clojure.string/lower-case
;;          clojure.string/trim)
;;    string))

(defn img [path]
  (str "/assets/imgs/" path))

(defn format-inst [inst]
  (let [formatter (.. DateTimeFormatter
                      (ofPattern "MMM dd, yyyy")
                      (withLocale Locale/US)
                      (withZone (ZoneId/of "Z")))]
    (.format formatter inst)))

(comment (format-inst (. #inst "2022-03-03" toInstant)))

(defn spit-ornament []
  (let [css-file "resources/assets/css/ornament.css"]
    (io/make-parents css-file)
    (spit css-file (ornament/defined-styles #_{:preflight? true}))))

