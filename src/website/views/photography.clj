(ns website.views.photography
  (:require [website.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.element :only [link-to image]]
        [org.satta.glob]
        [clojure.string :only [split]]))

(defpartial photo-list [img]
  [:p (image (str "/thumbs/" img) "")])

(defpage "/photography" []
  (common/layout
   [:p "This are a few photographs that I have taken."]
   [:div#photos
    (let [photos (map (fn [f]
                        (last (split (.getCanonicalPath f) #"/")))
                      (glob "resources/public/photos/*.jpg"))]
      (map photo-list photos))]))

