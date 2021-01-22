(ns gaiwan.core
  (:require [clojure.java.io :as io]
            [hiccup.core :as hc]
            [gaiwan.home :refer [home-page]]
            [gaiwan.about :refer [about-page]]
            [gaiwan.blog :refer [blog-page]]))

(defn build []
  (println "Building...")
  (io/make-parents "_site/about/index.html")
  (io/make-parents "_site/blog/index.html")
  (spit "_site/index.html" (hc/html (home-page "")))
  (spit "_site/about/index.html" (hc/html (about-page "")))
  (spit "_site/blog/index.html" (hc/html (blog-page "")))
  (println "Build complete"))

(comment
  (build))