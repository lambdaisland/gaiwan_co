(ns user
  (:require [gaiwan.core :as core]
            [lambdaisland.webstuff.bootstrap :as bootstrap]
            [gaiwan.http :as http]))

(defn build [& args]
  (core/build))

(defn go [& args]
  (bootstrap/go :dev))
