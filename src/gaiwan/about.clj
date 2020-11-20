(ns gaiwan.about
  (:require [gaiwan.common :as common]))

(def body
  [:div "About page"])

(defn about-page [content]
  ["<!DOCTYPE html>\n"
   [:html (common/gen-head) body]])