(ns gaiwan.utils)

(defn slugify
  [string]
  ((comp #(clojure.string/replace % #" " "-")
         clojure.string/lower-case
         clojure.string/trim)
   string))
