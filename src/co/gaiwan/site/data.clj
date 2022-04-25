(ns co.gaiwan.site.data
  (:require [co.gaiwan.site.utils :as utils]))

(def team-members
  [{:title "Arne Brasseur (Berlin)"
    :subtitle "@plexus"
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
    :image "https://avatars.githubusercontent.com/u/43312651?v=4"
    :description '([:p "Ariel is finishing up her last year as a Computer
                    Science student, where she built numerous projects with C++,
                    Java, Javascript, and Go. We introduced her to Clojure,
                    which she took to like fish takes to water. Her thirst for
                    knowledge has not stopped growing. "]
                   [:p "In her free time she likes to develop video games."])}
   {:title "Alys Brooks (Madison)"
    :subtitle "@alyssbrooks"
    :image "https://avatars.githubusercontent.com/u/1570381?v=4"
    :description '([:p "Alyss is a professional writer and editor by day and a programmer by night. She has worked as a technical writer at Epic."]
                   [:p "She loves open source and photography."])}
   {:title "Mitesh Shah (Mumbai)"
    :subtitle "@oxalorg"
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
    :image "https://avatars.githubusercontent.com/u/3061798?v=4"
    :description '([:p "Laurence is an experienced developer with a knack for
    understanding the needs of the customer, and delivering pragmatic solutions.
    He has created bespoke systems for Taiwan-based SMBs, and offers consulting
    to the LINE corporation."])}
   {:title "Joshua Ballanco (Miami)"
    :subtitle "@jballanc"
    :image (utils/img "avatars/jballanc.jpg")
    :description
    '([:p "Josh has built operating systems with Apple, local
       news sites with AOL, and served as the Chief Scientist for a
       world-wide distributed team of programming and design consultants."]
      [:p "He even managed to complete his Ph.D. in Computational Evolutionary Dynamics along the way."]
      [:p "He currently works remotely from his home in Miami where he lives with his beautiful wife and two young kids."])}])

(def faqs [{:question ""}])

(def projects [])
