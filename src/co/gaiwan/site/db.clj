(ns co.gaiwan.site.db
  (:require [co.gaiwan.site.utils :as utils]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [markdown.core :as m])
  (:import [java.io StringWriter]))

(defn- get-files []
  (filter
   #(str/ends-with? (.getName %) ".md")
   (file-seq (io/file (io/resource "posts")))))

(defn- meta-markdown [input]
  (let [output (new StringWriter)
        metadata (m/md-to-html input output :parse-meta? true)
        html     (.toString output)
        meta (if (nil? (:slug metadata))
               (assoc metadata :slug (utils/slugify (:title metadata)))
               metadata)]
    {:meta meta :html html}))

(defn- get-posts []
  (into {}
        (comp
         (map meta-markdown)
         (map (juxt #(get-in % [:meta :slug]) identity)))
        (get-files)))

(def posts (delay (get-posts)))
