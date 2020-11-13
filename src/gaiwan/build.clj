(ns gaiwan.build
  (:require [babashka.pods :as pods]
            [babashka.classpath :refer [add-classpath]]))

(add-classpath "src")
(require '[gaiwan.home :refer [home-page]])

(pods/load-pod "bootleg")
(require '[pod.retrogradeorbit.bootleg.utils :as utils]
         '[pod.retrogradeorbit.bootleg.file :as blfile])

(blfile/mkdir "_site")
(spit "_site/index.html" (utils/convert-to (home-page "") :html))
