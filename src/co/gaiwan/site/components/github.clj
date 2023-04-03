(ns co.gaiwan.site.components.github
  (:require [clj-http.client :as http]
            [cheshire.core :as json]))

(def timeout (* 15 60 1000))

(defonce stargazers-cache (atom {}))

(defn fetch-stargazers [user repo]
  (get
   (json/parse-string
    (:body
     (http/get (str "http://api.github.com/repos/" user "/" repo))))
   "stargazers_count"))

(defn stargazers [user repo]
  (let [now (System/currentTimeMillis)
        fetch! #(let [stars (fetch-stargazers user repo)]
                  (swap! stargazers-cache assoc [user repo] {:stars stars :millis now})
                  stars)]
    (if-let [{:keys [stars millis]} (get @stargazers-cache [user repo])]
      (if (< timeout (- now millis))
        (fetch!)
        stars)
      (fetch!))))
