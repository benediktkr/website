(ns website.views.welcome
  (:require [website.views.common :as common]
            [website.static :as static]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.element :only [link-to]]
        [org.satta.glob]))


(defpage "/" []
  (common/layout
   [:h2 "Hello"]
   [:p "My name is Benedikt Kristinsson and  you have found my website. I'm a human being, I'm a tinkerer. I currently make my living as a programmer at " (link-to "http://audkenni.is" "this place") "." ]
   [:h2 "Projects"]
   [:ul
    [:li (link-to "/projects/ardrand" "ardrand") ": An attempt at making a true RNG."]]
   [:h2 "Stuff O' Interest"]
   [:ul
    [:li (link-to "/cv1.pdf" "My Curriculum Vitae")]
   ;[:li (link-to "http://stuckinreykjavik.com" "www.stuckinreykjavik.com")]
    [:li (link-to "/Found_Reykjavik_144dpi.pdf" "Found Reykjavík") " (photobook)"]
    [:li "My public key"]
    [:li (link-to "img/selfie.jpg" "A picture of me" )]]
   [:h2 "Online presence"]
   [:ul
    [:li (link-to "http://www.facebook.com/benedikt.kristinsson" "Facebook")]
    [:li (link-to "http://reykjavik.academia.edu/BenediktKristinsson" "Academica.edu")]
    [:li (link-to "http://gitorious.org/~benediktkr" "gitorious.org")]
    [:li (link-to "http://www.flickr.com/photos/gurkubondinn" "Flickr") " (not updated)"]
    [:li (link-to "http://stackoverflow.com/users/386827/benedikt" "StackOverflow.com")]]
   [:h2 "About"]
   [:ul#about
    [:li "Email: " [:em "benediktk@gmail.com"]]
    [:li "IRC: benedikt on freenode"]
    [:li "Phone: (+354) 698 3533"]
    [:li "Twitter: " [:em "@benediktkr"]]
    [:li "Blood type: A+"]]))

