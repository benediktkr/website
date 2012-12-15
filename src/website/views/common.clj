(ns website.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css html5]]
        [hiccup.core :only [html]]
        [hiccup.element :only [link-to]]
        [clojure.core :only [interpose]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "Benedikt Kristinsson"]
               (include-css "/css/style.css")]
              [:body
               [:div#title [:h1 "benedikt.sudo.is"]]
               [:div#menu (interpose " || " [(link-to "/" "home")
                                             (link-to "/projects" "projects") 
                                             (link-to "/photography" "photography")])]
               [:div#content
                
                
                content]]))
