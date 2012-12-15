(ns website.views.photography
  (:require [website.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage defpartial]]
        [hiccup.element :only [link-to]]
        [org.satta.glob]))
