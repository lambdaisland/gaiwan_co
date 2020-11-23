(ns gaiwan.build
  (:require [babashka.pods :as pods]
            [babashka.classpath :refer [add-classpath]]))

(add-classpath "src")
(require '[gaiwan.home :refer [home-page]]
         '[gaiwan.about :refer [about-page]])

(pods/load-pod "bootleg")
(require '[pod.retrogradeorbit.bootleg.utils :as utils]
         '[pod.retrogradeorbit.bootleg.file :as blfile])

(defn build []
  (println "Building...")
  (blfile/mkdir "_site")
  (blfile/mkdir "_site/about")
  (spit "_site/index.html" (utils/convert-to (home-page "") :html))
  (spit "_site/about/index.html" (utils/convert-to (about-page "") :html))
  (println "Build complete"))

(build)