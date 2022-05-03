(ns user)

(defmacro jit
  "Shorthand for [[requiring-resolve]]. We use this because `user.clj` gets loaded
  automatically, and we don't want to load every namespace in the project with
  it. This would make starting a REPL too slow. It would also mean that any
  syntax error would stop you from starting a REPL."
  [sym]
  `(requiring-resolve '~sym))

(defn build [& args]
  ((jit co.gaiwan.site/build)))

(defn go [& args]
  ((jit co.gaiwan.site/serve)))

(defn browse []
  ((jit clojure.java.browse/browse-url) "http://localhost:9000"))
