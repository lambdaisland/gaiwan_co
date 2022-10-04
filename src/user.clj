(ns user)

(defmacro jit
  "Shorthand for [[requiring-resolve]]. We use this because `user.clj` gets loaded
  automatically, and we don't want to load every namespace in the project with
  it. This would make starting a REPL too slow. It would also mean that any
  syntax error would stop you from starting a REPL."
  [sym]
  `(requiring-resolve '~sym))

(defn develop [& args]
  ((jit co.gaiwan.site/develop)))

(defn serve [& args]
  ((jit co.gaiwan.site/serve)))

(defn publish [& args]
  ((jit co.gaiwan.site/publish)))

(defn browse []
  ((jit clojure.java.browse/browse-url) "http://localhost:6899"))
