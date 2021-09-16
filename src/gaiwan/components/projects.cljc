(ns gaiwan.components.projects)

(def lioss-data
  {:title "Lambda Island Open Source",
   :image
   "https://raw.githubusercontent.com/lambdaisland/open-source/master/artwork/lighthouse_readme.png",
   :description
   [:div
    [:p {:class "text-gray-800 pb-2"}
     "All Gaiwan engineers are active open source contributors, and we have
        several open source libraries we created and maintain, available through
        the Lambda Island brand. "]
    [:p {:class "text-gray-800"}
     "These projects often stem from needs we saw in client projects, or in
        the community in general. By opening them up we make sure we can use
        these building blocks on subsequent projects."]]})

(def heart-logo
  [:svg {:viewbox "0 0 80 80", :xmlns "http://www.w3.org/2000/svg"}
   [:path
    {:d
     "M77.4 26.5c-1.7-4.3-4.1-8.2-7.2-11.7s-6.7-6.4-10.7-8.7C55.4 3.6 50.8 2 46.1 1.2 44 .8 41.8.7 39.7.7c-4.6 0-9.2.8-13.6 2.4-4.3 1.5-8.3 3.8-11.8 6.7-3.6 2.9-6.6 6.3-8.9 10.3-2.4 4-4.1 8.5-4.8 13.1-.3 2-.5 4.1-.5 6.1C.1 44 1 48.6 2.6 53c1.6 4.3 4 8.4 7 11.9 3 3.6 6.6 6.6 10.6 9 4.1 2.4 8.6 4.1 13.3 4.9 2.1.3 4.3.5 6.4.5 8.6 0 16.9-2.9 23.7-8.1.5-.4.8-.9.9-1.5.1-.6-.1-1.2-.5-1.7s-.9-.8-1.5-.9c-.6-.1-1.2.1-1.7.5-6 4.6-13.3 7.2-20.9 7.2-1.9 0-3.8-.2-5.7-.5-4.2-.7-8.2-2.1-11.8-4.3-3.6-2.1-6.7-4.8-9.4-8s-4.8-6.8-6.2-10.6c-1.5-3.9-2.2-8-2.2-12.1 0-1.8.1-3.6.4-5.4.7-4.1 2.1-8 4.2-11.5s4.8-6.5 7.9-9.1c3.2-2.6 6.7-4.6 10.5-5.9 3.9-1.4 7.9-2.1 12.1-2.1 1.9 0 3.8.2 5.7.5 4.2.7 8.2 2.1 11.9 4.2 3.6 2 6.8 4.7 9.6 7.8 2.7 3.1 4.8 6.6 6.4 10.3 1.5 3.8 2.3 7.8 2.3 11.9 0 1.7-.1 3.5-.4 5.2-.2 1.3-.7 2.6-1.3 3.8-.6 1.2-1.4 2.2-2.2 3.3h-.1l-.3.3c-.7.7-1.4 1.2-2.3 1.5-.8.3-1.7.5-2.6.5-.9 0-1.8-.1-2.6-.4s-1.6-.8-2.3-1.4l-5.2-5.2 5.1-5.1c1.1-1.1 1.9-2.4 2.5-3.8.6-1.4.9-2.9.9-4.4s-.3-3-.9-4.4c-.6-1.4-1.5-2.8-2.6-3.9s-2.4-2-3.9-2.6c-1.4-.6-2.9-.9-4.4-.9s-3 .3-4.4.9c-1.4.6-2.7 1.4-3.8 2.5l-.1.1-1.7 1.6c-.4.4-.7 1-.7 1.6 0 1.3 1 2.3 2.3 2.3.6 0 1.2-.2 1.6-.7l1.5-1.5c.7-.7 1.5-1.2 2.3-1.5s1.8-.5 2.7-.5c.9 0 1.8.2 2.7.5.9.4 1.7.9 2.3 1.6.7.7 1.2 1.5 1.6 2.3.3.8.5 1.8.5 2.7 0 .9-.2 1.8-.5 2.7-.4.9-.9 1.7-1.6 2.3l-5 5-18.1-18.3-.1-.1c-1.1-1-2.3-1.9-3.7-2.4-1.4-.6-2.9-.9-4.4-.9s-3 .3-4.4.9c-1.4.6-2.8 1.5-3.9 2.6s-2 2.4-2.6 3.9c-.6 1.4-.9 2.9-.9 4.4s.3 3 .9 4.4c.6 1.4 1.4 2.7 2.4 3.7l.1.1.1.1 19.8 19.7c.4.5 1 .8 1.7.8.6-.2 1-.3 1.6-.8l11.6-11.6 5.3 5.3.1.1c1.1 1 2.4 1.8 3.8 2.3s2.8.8 4.3.7c1.5 0 2.9-.3 4.3-.9 1.1-.4 2.1-1 2.9-1.8.2-.1.3-.2.4-.3l.2-.2.2-.2.1-.1.3-.3c1.1-1.3 2.2-2.7 3-4.3.9-1.6 1.5-3.4 1.8-5.2.3-2 .5-3.9.5-5.9 0-4.7-.9-9.3-2.6-13.6zM39.6 57.6L21.2 39.4c-.6-.7-1.2-1.4-1.5-2.3-.3-.9-.5-1.8-.5-2.7 0-.9.2-1.9.5-2.7.4-.8.9-1.6 1.6-2.3.6-.7 1.4-1.2 2.3-1.6.9-.3 1.8-.5 2.7-.5.9 0 1.9.2 2.7.5.9.3 1.6.9 2.3 1.5l18.3 18.3-10 10z"
     :fill "#e25f7d"}]])

(def heart-of-clojure-data
  {:title "Heart of Clojure"
   :image "https://heartofclojure.eu/img/hoc-logo-white.svg"
   :svg heart-logo
   :description
   [:div
    [:p {:class "text-gray-800"}
     "Gaiwan GmbH is the initiator and legal entity backing the Heart of Clojure
     community conference. We provide the organizational infrastructure to be
     able to pull off such an event, and manage a big chunk of the work that
     goes into organizing. We also provide a “parachute sponsorship”, patching
     up any holes in the budget that may arise."]]})

(defn card [{:keys [title description svg image]}]
  [:div {:class "mx-auto bg-white border rounded-lg shadow-xl"}
   [:div {:class "flex flex-col items-center p-4 rounded-lg lg:flex-row"}
    [:div {:class "flex flex-col w-full text-blueGray-500 lg:ml-4"}
     [:h2
      {:class
       "mt-4 mb-4 text-xl font-bold text-black lg:mt-0 title-font"}
      title]
     [:div {:class "mb-3 text-base leading-relaxed text-blueGray-500"}
      description]]
    [:div
     {:class
      "flex items-center justify-center w-full lg:justify-start lg:w-1/2"}
     (if svg
       svg
       [:img
        {:alt "placeholder",
         :class "rounded-lg mx-auto",
         :src image}])]]])

(defn section []
  [:div {:class "bg-white"}
   [:div {:class "mx-auto py-12 px-4 max-w-7xl sm:px-6 lg:px-8"}
    [:div {:class "space-y-12"}
     [:h2 {:class "text-3xl font-extrabold tracking-tight sm:text-4xl"}
      "Our projects"]
     [:div
      {:class
       "space-y-12 lg:grid lg:grid-cols-2 lg:items-start lg:gap-x-8 lg:gap-y-12 lg:space-y-0"}
      (card lioss-data)
      (card heart-of-clojure-data)]]]])
