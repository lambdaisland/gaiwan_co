(ns co.gaiwan.site.data
  (:require [co.gaiwan.site.utils :as utils]))

(def homepage-cta {:title "Get a free 20 minute consultation!"
                   :subtitle "Let's grab a cup of e-tea and figure out how to relieve you of your business stress!"
                   :link "mailto:contact@gaiwan.co"
                   :button-text "Contact us!"})

(def team-members
  [{:title "Arne Brasseur (Berlin)"
    :subtitle "@plexus"
    :link "https://github.com/plexus"
    :image "https://avatars.githubusercontent.com/u/32212?v=4"
    :description '([:p "Arne has been delivering software solutions for well
    over a decade, as well as coaching individuals and teams on topics both
    technical and organizational."]
                   [:p "Since 2013 he's been coaching and consulting companies
                   solve complicated real world problems. He has a natural
                   instinct to break down highly complex problems and explain
                   them as a series of simple solutions."]
                   [:p "He loves a nice cup of tea, and likes to to go for runs."])}
   {:title "Felipe Barros (Recife)"
    :subtitle "@barrosfelipe"
    :link "https://github.com/barrosfelipe"
    :image "https://avatars.githubusercontent.com/u/9657386?v=4"
    :description '([:p "While still at school, GNU/Linux liberated Felipe from
                   the shackles of digital oblivion and corporate abuse."]
                   [:p "Being a keyboard enthusiast who follows the Dvorak
                   branch of the Emacs faith, he already manipulated text in Vim
                   and Emacs way before his renewed interest in computer
                   programming and cherry-picked the Clojure/ClojureScript path
                   after falling in love with Rich Hickey’s capillary
                   parentheses/curls."]
                   #_[:p "An arts person, likes to spend free time writing or
                   drawing and can often be caught talking about interfaces as
                   handcrafted, artisanal work."])}
   {:title "Ariel Alexi (Rosh HaAyin)"
    :subtitle "@ArielA147"
    :link "https://github.com/ArielA147"
    :image "https://avatars.githubusercontent.com/u/43312651?v=4"
    :description '([:p "Ariel is finishing up her last year as a Computer
                    Science student, where she built numerous projects with C++,
                    Java, Javascript, and Go. We introduced her to Clojure,
                    which she took to like fish takes to water. Her thirst for
                    knowledge has not stopped growing. "]
                   [:p "In her free time she likes to develop video games."])}
   {:title "Alys Brooks (Madison)"
    :subtitle "@alysbrooks"
    :link "https://github.com/alysbrooks"
    :image (utils/img "avatars/alys.jpg")
    :description '([:p "Alyss is a professional writer and editor by day and a programmer by night. She has worked as a technical writer at Epic."]
                   [:p "She loves open source and photography."])}
   {:title "Mitesh Shah (Mumbai)"
    :subtitle "@oxalorg"
    :link "https://github.com/oxalorg"
    :image (utils/img "avatars/mitesh-oxalorg.jpg")
    :description '([:p "Mitesh learnt coding because of his desire to hack video
                    games. This slowly turned to a passion for all things computer."]
                   [:p "Active contributor to OSS, he was also funded by
                    ClojuristsTogether to work on Clojurians Log V2."]
                   [:p "He creates Clojure related screencasts on his "
                    [:a {:class "text-indigo-600"
                         :href "https://youtube.com/c/oxalorg"} "YouTube Channel"]
                    "."])}
   {:title "Laurence Chen (Taipei)"
    :subtitle "@humorless"
    :link "https://github.com/humorless"
    :image "https://avatars.githubusercontent.com/u/3061798?v=4"
    :description '([:p "Laurence is an experienced developer with a knack for
    understanding the needs of the customer, and delivering pragmatic solutions.
    He has created bespoke systems for Taiwan-based SMBs, and offers consulting
    to the LINE corporation."])}
   {:title "Joshua Ballanco (Miami)"
    :subtitle "@jballanc"
    :link "https://github.com/jballanc"
    :image (utils/img "avatars/jballanc.jpg")
    :description
    '([:p "Josh has built operating systems with Apple, local
       news sites with AOL, and served as the Chief Scientist for a
       world-wide distributed team of programming and design consultants."]
      [:p "He even managed to complete his Ph.D. in Computational Evolutionary Dynamics along the way."]
      [:p "He currently works remotely from his home in Miami where he lives with his beautiful wife and two young kids."])}])

(def faqs [{:question ""}])

(def tw-site "@GaiwanTeam")
(def tw-creator "@GaiwanTeam")
(def site-title "Gaiwan - A Clojure Consultancy")
(def site-description "Home for Gaiwan, a provider of technological expertise grown out of the consulting and development work of Lambda Island's Arne Brasseur")
(def base-url "https://gaiwan.co")

(def projects
  [{:client "IT Revolution"
    :title "Bespoke conference video editor"
    :description
    "ITRevolution hosts the biggest Devops conference - the DevOps
    Enterprise Summit. During the pandemic they shifted from
    in-person to a completely online conference which came with a
    host of problems. We helped them transition their entire
    operations to a cloud native solution. We also helped their
    team to be able to edit over 100 videos per conference
    fulfilling all of their custom operations using our in-house
    video editor frontend which uses FFMPEG DSL behind the scenes."
    :cta-text "Read in-depth of how we built it"
    :cta-url "https://itrevolution.com"
    :image-url (utils/img "work/itrev-video-editor.png")}
   {:client "re:Clojure Conf"
    :title "Built & Redesigned the reclojure.org website"
    :description
    "Gaiwan loves Clojure, which is why we love supporting
    community events like re:Clojure. You may have seen the amazing
    event website? That was us. A lightweight design, leveraging
    web standards for maximum accessibility, and a responsive
    experience across devices, all in an appealing package."
    :cta-text nil
    :cta-url nil
    :image-url (utils/img "work/reclojure.png")}
   {:client "Pitch"
    :title "Integration with a popular chatting service"
    :description
    "We helped Pitch in building a complex ClojureScript test
    runner suited to their codebase. We also helped in integrating
    the Pitch app into an extremely popular chatting service."
    :cta-text nil
    :cta-url nil
    :image-url (utils/img "work/pitch.png")}
   {:client "Eleven"
    :title "Metabase integration and financial queries"
    :description
    "We created the metabase driver for Datomic for Eleven and also
    open-sourced it. We then helped create and integrate their
    complicated financial reporting with metabase resulting in some
    pretty sweet graphs for their clients!."
    :cta-text nil
    :cta-url nil
    :image-url (utils/img "work/eleven.png")}
   {:client "Tidy"
    :title "Event sourcing features, major refactoring, and test setup"
    :description
    "Our team was introduced to help Tidy improve their codebase
    with Clojure best practices, to help them do Code Reviews, and
    to holistically work alongside their team. This included
    working on additional features on their Event Sourcing system
    using Postgres and XTDB. We also worked to add integration
    tests using Kaocha, setup CI testing, and add authentication
    and authorization to their GraphQL/Lacinia based stack. This
    involved refactoring of major parts of their system."
    :cta-text nil
    :cta-url nil
    :image-url (utils/img "work/tidy.png")}])

(def authors
  {:mitesh {:name "Mitesh"
            :twitter "@oxalorg"}
   :josh {:name "Joshua Ballanco"}})
