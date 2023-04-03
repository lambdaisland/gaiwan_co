(ns assets.pixels
  (:require [lambdaisland.ornament :as ornament :refer [defstyled]]))

(def palette
  {:white              "#fff"
   :lighter-gray       "#f7f7f7"
   :gray               "#cbcad2"
   :light-gray         "#e6e5eb"
   :black              "#21202a"
   :darker-gray        "#43424f"
   :dark-gray          "#8c8b97"
   })

;; -------------- PIXEL ART SEPARATOR
(defstyled pixel-art-separator :div
  :grid 
  {:grid-template-columns "repeat(20, minmax(2vmin, 1fr))"
   :grid-template-rows    "repeat(6, minmax(2vmin, 1fr))"})

(defstyled transparent-pixel :div {:background-color (palette :white)})

(defstyled lighter-gray-pixel :div {:background-color (palette :lighter-gray)})

(defstyled light-gray-pixel :div {:background-color (palette :light-gray)})

(defstyled gray-pixel :div {:background-color (palette :gray)})

(defstyled dark-gray-pixel :div {:background-color (palette :dark-gray)})

(defstyled darker-gray-pixel :div {:background-color (palette :darker-gray)})

(defstyled black-pixel :div {:background-color (palette :black)})

(defn pixel [color]
  (case color
    :t [transparent-pixel]
    :L [lighter-gray-pixel]
    :l [light-gray-pixel]
    :g [gray-pixel]
    :d [dark-gray-pixel]
    :D [darker-gray-pixel]
    :b [black-pixel]))

(defn pixel-art [color-matrix]
  [pixel-art-separator
   (map pixel color-matrix)])

(defstyled pixelated :div
  :flex :flex-row
  {:overflow  "hidden"
   :max-width "100vw"
   :width     "100%"})

(def color-matrix
  [:t :t :t :t :L :t :t :t :t :t :t :t :t :t :t :L :t :t :t :t
   :t :l :t :t :l :l :l :t :l :l :l :l :t :l :t :l :t :l :t :t
   :l :g :g :l :l :g :g :l :g :l :g :l :l :l :g :g :l :l :g :g
   :g :d :d :d :d :g :d :g :g :g :d :g :d :g :g :d :d :d :d :d
   :D :d :d :D :D :D :d :d :d :D :D :D :d :D :d :D :D :d :d :d
   :D :D :b :b :D :b :b :D :D :D :b :D :b :b :b :D :b :b :D :D])

(defn create-pixelarted [color-matrix-format]
  [pixelated (repeat 10 [pixel-art color-matrix-format])])
