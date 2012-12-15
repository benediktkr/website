(ns website.views.projects
  (:require [website.views.common :as common]
            [website.static :as static]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.element :only [link-to]]))

(defpartial paper [p]
  [:h1 (:title p)]
  (when (:info p)
    [:p (:info p)])

  [:h2 "Abstract"]
  [:p ( :abstract p)]
  
  [:ul
   [:li (link-to (str "/papers/" (:paper p)) "paper")]
   (when (:code p)
     [:li (link-to (:code p) "code")])
   (when (:skemman p)
     [:li (link-to (:skemman p) "skemman")])])

(defpartial papers-item [paper]
  [:li (link-to (str "/projects/" (:title paper)) (:title paper)) (str ": " (:longname paper))
   (when (:info paper)
      [:p (:info paper)])])

(defpage "/projects" []
  (common/layout
   [:h2 "Projects"]
   [:ul
    (map (fn [[k v]] (papers-item v)) static/papers)]))

(defpage "/projects/:prj" {:keys [prj]}
  (common/layout
   ; TODO: Return some error if nil
   (if ((keyword prj) static/papers)
     (do
       (let [p ((keyword prj) static/papers)]
         (paper p)))
     (str "Error"))))

;; Shortcuts

(defpage "/ardrand" []
  ;(ring.util.response/redirect "/projects/ardrand")
  (common/layout
   (paper (:ardrand static/papers))))