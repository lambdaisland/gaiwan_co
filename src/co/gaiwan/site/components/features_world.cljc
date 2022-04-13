(ns co.gaiwan.site.components.features-world)

(defn features-world []
  [:section
   [:div {:class "max-w-6xl mx-auto px-4 sm:px-6"}
    [:div {:class "py-12 md:py-20"}
     #_[:comment " Section header "]
     [:div {:class "max-w-3xl mx-auto text-center pb-12 md:pb-16"}
      [:h1 {:class "h2 mb-4"} "Gaiwan is a 100% diverse, and distributed team"]
      [:p {:class "text-xl text-gray-600"}
       "We truly understand and leverage how to scale both our team AND our projects internationally"]]
     #_[:comment " World illustration "]
     [:div {:class "flex flex-col items-center pt-12 md:pt-16"}
      [:div {:class "relative"} #_[:comment " Halo effect "]
       [:svg
        {:class
         "absolute inset-0 left-1/2 top-1/2 transform -translate-x-1/2 -translate-y-1/2 pointer-events-none",
         :height "800",
         :style "max-width: 200%;",
         :viewbox "0 0 800 800",
         :width "800",
         :xmlns "http://www.w3.org/2000/svg"}
        [:g {:class "fill-current text-gray-400 opacity-75"}
         [:circle {:class "pulse", :cx "400", :cy "400", :r "200"}]
         [:circle {:class "pulse pulse-1", :cx "400", :cy "400", :r "200"}]
         [:circle {:class "pulse pulse-2", :cx "400", :cy "400", :r "200"}]]]
       #_[:comment " Globe image "]
       [:img
        {:alt "Planet",
         :class "relative rounded-full shadow-xl",
         :height "400",
         :src "../images/planet.png",
         :width "400"}]
       #_[:comment " Static dots "]
       [:svg
        {:class "absolute top-0 w-full h-auto",
         :style "left: 12%;",
         :viewbox "0 0 400 400",
         :xmlns "http://www.w3.org/2000/svg"}
        [:defs
         [:filter#world-ill-a
          {:filterunits "objectBoundingBox",
           :height "185.6%",
           :width "183.3%",
           :x "-41.7%",
           :y "-34.2%"}
          [:feoffset {:dy "4", :in "SourceAlpha", :result "shadowOffsetOuter1"}]
          [:fegaussianblur
           {:in "shadowOffsetOuter1",
            :result "shadowBlurOuter1",
            :stddeviation "6"}]
          [:fecolormatrix
           {:in "shadowBlurOuter1",
            :values
            "0 0 0 0 0 0 0 0 0 0.439215686 0 0 0 0 0.956862745 0 0 0 0.32 0"}]]
         [:filter#world-ill-c
          {:filterunits "objectBoundingBox",
           :height "271.2%",
           :width "266.7%",
           :x "-83.3%",
           :y "-68.5%"}
          [:feoffset {:dy "4", :in "SourceAlpha", :result "shadowOffsetOuter1"}]
          [:fegaussianblur
           {:in "shadowOffsetOuter1",
            :result "shadowBlurOuter1",
            :stddeviation "6"}]
          [:fecolormatrix
           {:in "shadowBlurOuter1",
            :values
            "0 0 0 0 0 0 0 0 0 0.439215686 0 0 0 0 0.956862745 0 0 0 0.32 0"}]]
         [:filter#world-ill-e
          {:filterunits "objectBoundingBox",
           :height "147.6%",
           :width "114.5%",
           :x "-7.3%",
           :y "-23.8%"}
          [:fegaussianblur {:in "SourceGraphic", :stddeviation "2"}]]
         [:ellipse#world-ill-b
          {:cx "51", :cy "175.402", :rx "24", :ry "23.364"}]
         [:ellipse#world-ill-d
          {:cx "246", :cy "256.201", :rx "12", :ry "11.682"}]
         [:lineargradient#world-ill-f
          {:x1 "50%", :x2 "50%", :y1 "0%", :y2 "100%"}
          [:stop {:offset "0%", :stop-color "#0070F4", :stop-opacity "0"}]
          [:stop
           {:offset "52.449%", :stop-color "#0070F4", :stop-opacity ".64"}]
          [:stop {:offset "100%", :stop-color "#0070F4", :stop-opacity "0"}]]]
        [:g
         {:fill "none", :fill-rule "evenodd", :transform "translate(0 -.818)"}
         [:use
          {:fill "#000",
           :filter "url(#world-ill-a)",
           :xlink:href "#world-ill-b"}]
         [:use {:fill "#0070F4", :xlink:href "#world-ill-b"}]
         [:use
          {:fill "#000",
           :filter "url(#world-ill-c)",
           :xlink:href "#world-ill-d"}]
         [:use {:fill "#0070F4", :xlink:href "#world-ill-d"}]
         [:ellipse
          {:cx "293",
           :cy "142.303",
           :fill "#0070F4",
           :fill-opacity ".32",
           :rx "8",
           :ry "7.788"}]
         [:ellipse
          {:cx "250",
           :cy "187.083",
           :fill "#0070F4",
           :fill-opacity ".64",
           :rx "6",
           :ry "5.841"}]
         [:ellipse
          {:cx "13",
           :cy "233.811",
           :fill "#0070F4",
           :fill-opacity ".64",
           :rx "2",
           :ry "1.947"}]
         [:ellipse
          {:cx "29", :cy "114.072", :fill "#0070F4", :rx "2", :ry "1.947"}]
         [:path
          {:d "M258 256.2l87-29.204",
           :filter "url(#world-ill-e)",
           :opacity ".16",
           :stroke "#666",
           :stroke-width "2"}]
         [:path
          {:d
           "M258 251.333c111.333-40.237 141-75.282 89-105.136M136 103.364c66.667 4.543 104.667 32.45 114 83.72",
           :stroke "url(#world-ill-f)",
           :stroke-dasharray "2",
           :stroke-width "2"}]]]
       #_[:comment " Dynamic dots "]
       [:svg
        {:class "absolute max-w-full",
         :height "48",
         :style "width: 12%;top: 45%; left: 50%;",
         :viewbox "0 0 48 48",
         :width "48",
         :xmlns "http://www.w3.org/2000/svg"}
        [:g {:class "fill-current text-blue-600"}
         [:circle
          {:class "pulse pulse-mini pulse-1", :cx "24", :cy "24", :r "8"}]
         [:circle
          {:class "pulse pulse-mini pulse-2", :cx "24", :cy "24", :r "8"}]
         [:circle {:cx "24", :cy "24", :r "8"}]]]
       [:svg
        {:class "absolute max-w-full",
         :height "48",
         :style "width: 12%;top: 19%; left: 46%;",
         :viewbox "0 0 48 48",
         :width "48",
         :xmlns "http://www.w3.org/2000/svg"}
        [:g {:class "fill-current text-blue-600"}
         [:circle {:class "pulse pulse-mini", :cx "24", :cy "24", :r "8"}]
         [:circle
          {:class "pulse pulse-mini pulse-2", :cx "24", :cy "24", :r "8"}]
         [:circle {:cx "24", :cy "24", :r "8"}]]]
       #_[:comment " Avatars "]
       [:img
        {:alt "Planet avatar 01",
         :class "absolute max-w-full transform animate-float",
         :height "105",
         :src "../images/planet-avatar-01.png",
         :style "width: 65.25%; top: -3%; right: -27%;",
         :width "261"}]
       [:img
        {:alt "Planet avatar 02",
         :class
         "absolute max-w-full transform animate-float animation-delay-1000",
         :height "173",
         :src "../images/planet-avatar-02.png",
         :style "width: 88.7%; bottom: -20%; right: -18%;",
         :width "355"}]
       #_[:comment " Black icon "]
       [:svg
        {:class "absolute top-0 max-w-full w-20 h-auto rounded-full shadow-xl",
         :style "width: 20%; left: 6%;",
         :viewbox "0 0 80 80",
         :xmlns "http://www.w3.org/2000/svg"}
        [:circle
         {:class "fill-current text-gray-800", :cx "40", :cy "40", :r "40"}]
        [:path
         {:class "stroke-current text-white",
          :d
          "M30.19 41.221c7.074 3.299 12.957-4.7 20.03-1.401l1.769.824-1.419-3.883M43.988 50.877l3.887-1.41-1.769-.824c-2.19-1.021-3.475-2.651-4.42-4.512M38.724 36.91c-.944-1.86-2.23-3.49-4.42-4.512",
          :stroke-linecap "square",
          :stroke-width "2"}]]
       #_[:comment " Blue icon "]
       [:svg
        {:class "absolute max-w-full w-16 h-auto rounded-full shadow-xl",
         :style "width: 16%; top: 32%; left: -27%;",
         :viewbox "0 0 64 64",
         :xmlns "http://www.w3.org/2000/svg"}
        [:circle
         {:class "fill-current text-blue-600", :cx "32", :cy "32", :r "32"}]
        [:path
         {:class "stroke-current text-white",
          :d "M20.733 31.416l18.127-8.452M43.039 31.926L24.913 40.38",
          :fill "none",
          :stroke-width "2"}]
        [:path
         {:class "stroke-current text-white",
          :d
          "M32.238 20.595l6.622 2.369-2.442 6.594M31.534 42.747l-6.621-2.368 2.442-6.595",
          :fill "none",
          :stroke-linecap "square",
          :stroke-width "2"}]]
       #_[:comment " White icon "]
       [:svg
        {:class "absolute max-w-full w-16 h-auto rounded-full shadow-xl",
         :style "width: 16%; top: 55%; right: -16%;",
         :viewbox "0 0 64 64",
         :xmlns "http://www.w3.org/2000/svg"}
        [:circle
         {:class "fill-current text-gray-100",
          :cx "32",
          :cy "32",
          :fill "#FBFBFB",
          :r "32"}]
        [:path
         {:class "fill-current text-gray-700",
          :d
          "M37.11 32.44l-1.69 4.646-8.458-3.078.676-1.859-4.773 1.42 2.744 4.156.677-1.858 9.396 3.42a.994.994 0 001.278-.587l2.03-5.576-1.88-.684zM27.037 30.878l1.691-4.646 8.457 3.078-.676 1.858 4.773-1.42-2.744-4.155-.676 1.858-9.397-3.42a.994.994 0 00-1.278.587l-2.03 5.576 1.88.684z"}]]]]]]])
