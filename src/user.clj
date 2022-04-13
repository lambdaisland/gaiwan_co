(ns user
  (:require [co.gaiwan.site :as core]
            [lambdaisland.webstuff.bootstrap :as bootstrap]
            [co.gaiwan.site.http :as http]))

(defn build [& args]
  (core/build))

(defn go [& args]
  (bootstrap/go :dev))
