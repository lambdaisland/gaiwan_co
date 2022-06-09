(ns co.gaiwan.site.md-files
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [co.gaiwan.site.utils :as utils]
            [markdown.core :as m]
            [nextjournal.markdown :as md]
            [nextjournal.markdown.transform :as md-transform])
  (:import (java.io StringWriter)))

;;; aliases which you can use inside markdown hiccup blocks
(require '[co.gaiwan.site.components.cta :as cta])

;;; /aliases

(defn collect-files
  "File all .md files in the given directory"
  [dir]
  (filter
   #(str/ends-with? (.getName %) ".md")
   (file-seq (io/file dir))))

(def graal-js-sync-object (Object.))

(defn read-md+meta
  "Given a markdown file/reader, return a map with metadata and rendered HTML."
  [file]
  (let [[metadata num-lines] (m/parse-metadata file)
        markdown (str/join "\n" (drop num-lines (str/split (slurp file) #"\R")))]
    {:meta metadata
     :hiccup
     (locking graal-js-sync-object
       (md-transform/->hiccup
        (assoc md-transform/default-hiccup-renderers
               :code (fn [ctx {:keys [language content] :as node}]
                       (if (= "hiccup" language)
                         (let [[{:keys [text]}] content]
                           (binding [*ns* (the-ns (symbol (namespace `_)))]
                             (eval (read-string text))))
                         (md-transform/into-markup [:pre] ctx node))))
        (md/parse markdown)))}))

(defn slurp-files
  "Read in a sequence of markdown files, returns a map from slug to meta/html map."
  [files]
  (into {}
        (comp
         (map read-md+meta)
         (map (juxt #(get-in % [:meta :slug]) identity)))
        files))

(defn slurp-dir
  "Read in a directory of md files, returns a map from slug to meta/html map."
  [dir]
  (slurp-files (collect-files dir)))
