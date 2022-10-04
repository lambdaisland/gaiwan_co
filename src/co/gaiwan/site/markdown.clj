(ns co.gaiwan.site.markdown
  (:require [clojure.string :as str]
            [nextjournal.markdown :as md]
            [nextjournal.markdown.transform :as md-transform]))

;;; aliases which you can use inside markdown hiccup blocks
(require '[co.gaiwan.site.components.cta :as cta])

(def graal-js-sync-object (Object.))

(defn md-content
  "Given a markdown file, return a map with metadata and rendered HTML."
  [file]
  (let [markdown (str/join "\n" (str/split (slurp file) #"\R"))]
    (locking graal-js-sync-object
      (md-transform/->hiccup
       (assoc md-transform/default-hiccup-renderers
              :code (fn [ctx {:keys [language content] :as node}]
                      (if (= "hiccup" language)
                        (let [[{:keys [text]}] content]
                          (binding [*ns* (the-ns (symbol (namespace `_)))]
                            (eval (read-string text))))
                        (md-transform/into-markup [:pre] ctx node))))
       (md/parse markdown)))))

