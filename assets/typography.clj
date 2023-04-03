(ns assets.typography
  (:require [garden.units :as u]
            [garden.types]))

(def ->rem (partial garden.types/->CSSUnit :rem))

(defn base+px->rem [base px]
  (-> (u/px-div (u/px px) (u/px base))
      :magnitude
      float
      ->rem))

(def px16->rem (partial base+px->rem 16))

(def typefaces {:open-sans-regular {:font-family "open-sans, sans-serif"
                                    :font-weight 400
                                    :font-style "normal"}
                :open-sans-regular-italic {:font-family "open-sans, sans-serif"
                                           :font-weight 400
                                           :font-style "italic"}
                :open-sans-semibold {:font-family "open-sans, sans-serif"
                                     :font-weight 600
                                     :font-style "normal"}
                :open-sans-semibold-italic {:font-family "open-sans, sans-serif"
                                            :font-weight 600
                                            :font-style "italic"}
                :rubik-medium {:font-family "rubik, sans-serif"
                               :font-weight 500}})

(def typography
  {:h1 (assoc (typefaces :rubik-medium)
              :font-size (px16->rem 48)
              :line-height (px16->rem 58)
              :letter-spacing (px16->rem 2))
   :h2 (assoc (typefaces :rubik-medium)
              :font-size (px16->rem 36)
              :line-height (px16->rem 56)
              :letter-spacing (px16->rem 1))
   :h3 (assoc (typefaces :rubik-medium)
              :font-size (px16->rem 28)
              :line-height (px16->rem 38)
              :letter-spacing (px16->rem 0.75))
   :h4 (assoc (typefaces :rubik-medium)
              :font-size (px16->rem 24)
              :line-height (px16->rem 34)
              :letter-spacing (px16->rem 0.6))
   :h5 {:font-family "rubik, sans-serif"
        :font-weight 500
        :font-size (px16->rem 18)
        :line-height (px16->rem 28)
        :letter-spacing (px16->rem 0.3)}
   :h6 {:font-family "rubik, sans-serif"
        :font-weight 500
        :font-size (px16->rem 14)
        :line-height (px16->rem 24)
        :letter-spacing (px16->rem 0.2)}
   :subtitle-regular {:font-family "rubik, sans-serif"
                      :font-weight 500
                      :font-size (px16->rem 16)
                      :line-height (px16->rem 24)
                      :letter-spacing (px16->rem 0.1)}
   :subtitle-small {:font-family "rubik, sans-serif"
                    :font-weight 500
                    :font-size (px16->rem 14)
                    :line-height (px16->rem 18)
                    :letter-spacing (px16->rem 0.1)}
   :body-regular {:font-family "open-sans, sans-serif"
                  :font-weight 400
                  :font-size (px16->rem 20)
                  :line-height (px16->rem 34)
                  :letter-spacing (px16->rem 0.2)}
   :body-small {:font-family "open-sans, sans-serif"
                :font-weight 400
                :font-size (px16->rem 14)
                :line-height (px16->rem 22)
                :letter-spacing (px16->rem 0.1)}
   :button-main {:font-family "open-sans, sans-serif"
                 :font-weight 600
                 :font-size (px16->rem 22)
                 :line-height (px16->rem 32)
                 :letter-spacing (px16->rem 0.2)}
   :button-small {:font-family "open-sans, sans-serif"
                  :font-weight 600
                  :font-size (px16->rem 18)
                  :line-height (px16->rem 28)
                  :letter-spacing (px16->rem 0)}})
