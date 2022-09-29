(ns co.gaiwan.site.open-graph
  (:require [clojure.data.json :as json]
            [co.gaiwan.site.data :as data]))

(defn twitter-card-tags [{:keys [tw-type tw-site tw-creator url
                                 title description image]
                          :or {tw-type "summary"
                               tw-site data/tw-site
                               tw-creator data/tw-creator
                               title data/site-title
                               description data/site-description
                               url data/base-url
                               #_#_image logo-image}}]
  {"twitter:card" tw-type
   "twitter:site" tw-site
   "twitter:creator" tw-creator
   "twitter:url" url
   "twitter:title" title
   "twitter:description" description
   "twitter:image" image})

(defn open-graph-tags [{:keys [url og-type title updated-time modified-time
                               published-time site-name description section
                               image video-duration video-release-date]
                        :or {og-type "article"
                             site-name data/site-title
                             description data/site-description
                             title data/site-title
                             #_#_image logo-image}}]
  {"og:url" url
   "og:type" og-type
   "og:title" title
   "og:updated_time" updated-time
   "og:site-name" site-name
   "og:description" description
   "og:image" image
   "article:modified_time" modified-time
   "article:published_time" published-time
   "article:section" section
   "video:release_date" video-release-date
   "video:duration" video-duration})

(defn video-structured-schema [{:keys [name description upload-date thumbnail-url] :as _video}]
  (let [schema {"@context" "https://schema.org"
                "@type" "VideoObject"
                "name" name
                "description" description
                "uploadDate" upload-date
                "thumbnailUrl" thumbnail-url}]
    [:script {:type "application/ld+json"} (json/write-str schema :escape-slash false)]))

(defn generic-meta-tags [tags]
  {"description" (:description tags data/site-description)})

(defn social-tags [tags]
  (into [:<>
         [:title (:title tags data/site-title)]
         (when (:video-schema tags)
           (video-structured-schema (:video-schema tags)))]
        (comp
         cat
         (remove (comp nil? second))
         (map #(do [:meta {:name (first %) :content (second %)}])))
        [(generic-meta-tags tags)
         (twitter-card-tags tags)
         (open-graph-tags tags)]))
