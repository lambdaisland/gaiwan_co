(ns co.gaiwan.site.utils)

(defn slugify
  [string]
  ((comp #(clojure.string/replace % #" " "-")
         clojure.string/lower-case
         clojure.string/trim)
   string))

(defn img [path]
  (str "/assets/imgs/" path))
