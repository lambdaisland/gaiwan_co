(ns gaiwan.core
  (:require [clojure.java.io :as io]
            [hiccup.core :as hc]))

;; (defn build-blog-posts []
;;   (doseq [post (get-posts)]
;;     (let [path (str "_site/blog/" (get-in post [:meta :slug]) "/index.html")]
;;       (io/make-parents path)
;;       (spit path (hc/html (blog-post post))))))

;; (defn build []
;;   (println "Building...")
;;   (io/make-parents "_site/about/index.html")
;;   (io/make-parents "_site/blog/index.html")
;;   (spit "_site/index.html" (hc/html (home-page "")))
;;   (spit "_site/about/index.html" (hc/html (about-page "")))
;;   (spit "_site/blog/index.html" (hc/html (blog-page "")))
;;   (build-blog-posts)
;;   (println "Build complete"))
(defn build [])

(comment
  (build))
