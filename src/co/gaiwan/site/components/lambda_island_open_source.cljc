(ns co.gaiwan.site.components.lambda-island-open-source
  (:require [assets.icon-assets :as icon-assets]
            [garden.selectors :as gse]
            [assets.pixels :as pixels]
            [assets.typography :as typo]
            [co.gaiwan.site.components.github :as gh]
            [lambdaisland.ornament :as ornament :refer [defstyled]]))

(def palette 
  {:black              "#21202a"
   :darker-gray        "#43424f"
   :dark-gray          "#8c8b97"
   :gray               "#cbcad2"
   :light-gray         "#e6e5eb"
   :lighter-gray       "#f7f7f7"
   :white              "#fff"
   :primary-blue       "#4d7ad1"
   :secondary-blue     "#5257ab"
   :secondary-blue-alt "#4a4fa6"
   :light-blue         "#94afe3"
   :lighter-blue       "#a6bce8"
   :lightest-blue      "#d2ddf3"
   :even-lighter-blue  "#edf2fa"
   :dark-blue          "#112241"
   :light-green        "#cff9cf"
   :dark-green         "#3e5519"
   :warning            "#f38015"
   :error              "#fb4e6d"
   :success            "#21d37e"
   :box-shadow         "-2px 5px 3px 0 rgba(0, 0, 0, 0.1)"})

(defstyled showcase-section-lioss :section
  :flex
  {:flex-direction   "column"
   :align-items      "center"
   :margin           "0 auto"
   :min-height       "max-content"
   :padding          "3rem 1rem"
   :justify-content  "center"
   :background-color (palette :black)})

(defstyled outline-dark :div
  {}
  [:a ["&:focus-visible" 
       {:outline        [["2px" "solid" (palette :white)]]
        :outline-offset "0.5rem"
        :box-shadow     "none"
        :border-radius  "initial"}]])

;; -----------------  github-card  --------------------

(defstyled gh-card-logo :div
  {:max-height "6rem"
   :grid-area  "logo"})

(defstyled gh-card-title :a
  (typo/typography :h3)
  {:grid-area   "title"
   :margin      0
   :line-height "unset"}
  )

(defstyled gh-card-desc :p
  {:grid-area "desc"
   :margin    0})

(defstyled gh-card-stars :div
  {:grid-area   "stars"
   :display     "flex"
   :gap         "0.5rem"
   :align-items "flex-end"}
  [:svg :path {:stroke "goldenrod"
               :fill   "yellow"}])

(defstyled gh-card-wrapper :article
  {:display "grid"
   :grid-row-gap ".25rem"
   :grid-template-columns "auto 1fr"
   :grid-template-rows "repeat(3, auto)"
   :align-items "center"
   :height "min-content"
   :color (palette :white)
   :max-width "max-content"}
  [:a {:color (palette :white)}]
  [(gse/& (gse/nth-of-type "odd"))
   {:grid-template-areas [["title" "logo"]
                          ["desc" "logo"]
                          ["stars" "logo"]]
    :justify-items "end"}
   [:p {:text-align "right"}]
   [gh-card-stars {:flex-direction "row-reverse"}]]
  [(gse/& (gse/nth-of-type "even"))
   {:grid-template-areas [["logo" "title"]
                          ["logo" "desc"]
                          ["logo" "stars"]]
    :justify-items "start"}])

(defn gh-card [{:keys [logo url name desc stars]}]
  [gh-card-wrapper
   (when logo
     (cond
       (string? logo) [:img {:class [gh-card-logo] :src logo}]
       (vector? logo) logo))
   [gh-card-title {:href url} name]
   [gh-card-desc  desc]
   [gh-card-stars icon-assets/star [:a {:href "#"} stars]]])

;; -----------------------------

(defstyled title :h1
  (assoc (:h1 typo/typography)
         :grid-area "title"
         :color (palette ::white)))

(defstyled lioss-text :div
  {:color      "#fff"
   :margin-top "2rem"
   :padding    "1rem 0"}
  [:at-media {:min-width "40em"}
   {:text-align "center"}])

(defstyled lioss-layout :div
  {:display        "flex"
   :flex-direction "column"
   :gap            "1rem"}
  [:>
   [:svg {:grid-area "logo"
          :width "5rem"
          :justify-self "center"
          :align-self "center"
          :margin "1rem"
          :order 1}]
   ["article:first-of-type" {:grid-area "card1"
                             :justify-self "end"
                             :align-self "end"}]
   ["article:nth-of-type(2)" {:grid-area "card2"
                              :justify-self "start"}]
   ["article:nth-of-type(3)" {:grid-area "card3"
                              :align-self "end"}]
   ["article:nth-of-type(4)" {:grid-area "card4"}]
   ["article:nth-of-type(5)" {:grid-area "card5"
                              :justify-self "end"}]
   ["article:nth-of-type(6)" {:grid-area "card6"
                              :justify-self "start"}]]
  [:at-media {:min-width "60em"}
   {:display "grid"
    :grid-template-rows "repeat(3, auto)"
    :grid-gap "2rem 1rem"
    :grid-template-columns "1fr minmax(auto, 3rem) min-content minmax(auto, 3rem) 1fr"
    :grid-template-areas [["card1 card1 logo card2 card2"]
                          ["card3 ..... logo ..... card4"]
                          ["card5 card5 logo card6 card6"]]
    :margin-top "2rem"
    :margin-bottom "3rem"}
   [:> [:svg {:width "10rem"}]]])

(defstyled link-fix-dark :div
  {:font-size   "1em"
   :font-family "iosevka, monospace"
   :font-weight 600
   :color       (palette :light-blue)}
  ["&:visited" {:color (palette :primary-blue)}])

(defstyled copy :p
  {:max-width "60ch"})

(defn- stars [project]
  (gh/stargazers "lambdaisland" project))

;; --------------- lambda island section------------------ 

(defn lighthous []
[showcase-section-lioss 
 {:class [outline-dark]}
 [title 
  {:style {:color         (palette :white)
           :margin-bottom 0}} 
  "How we give back"]
 [copy {:class [lioss-text]} 
  "Through Gaiwan's educational arm, Lambda Island, all Gaiwan engineers create 
   and maintain several popular Clojure libraries and tools. 
   Check out the quality of our code in these open source projects."]
 [lioss-layout
  icon-assets/pixel-lighthouse
  ;; TODO: we should link to https://github.com/lambdaisland/open-source here
  ;; somewhere "See the full list"
  (for [[project title desc] 
        [["kaocha" "Kaocha" "Full featured next gen Clojure test runner."]
         ["deep-diff2" "deep-diff2" "Compare Clojure data structures."]
         ["uri" "lambdaisland/uri" "A idiomatic and cross-platform URI library."]
         ["regal" "Regal" "Royally reified regular expressions."]
         ["glogi" "Glögi" "A ClojureScript logging library based on goog.log."]
         ["ansi" "ANSI" "Convert ANSI escape codes to Hiccup."]]]
    [gh-card
     {:name title
      :url  (str "https://github.com/lambdaisland/" project)
      :desc desc
      :stars (stars project)
      }])]
 [copy {:class [lioss-text]}
  "We also maintain community infrastructure, like the " [:a {:class [link-fix-dark]
                                                              :href  "https://clojureverse.org/"} "ClojureVerse"]
  " forum and the " [:a {:href  "https://clojurians-log.clojureverse.org/"
                         :class [link-fix-dark]} "clojurians-log"]
  " Slack archive."] 
 ])
 
(defn lambdaisland-componnent []
  [:<>
   (pixels/create-pixelarted pixels/color-matrix)
   (lighthous)
   (pixels/create-pixelarted (reverse pixels/color-matrix))])

   