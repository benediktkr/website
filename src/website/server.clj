(ns website.server
  (:require [noir.server :as server]))

(server/load-views-ns 'website.views)

(defn -main [& m]
  (let [mode (keyword (or (first m) :prod))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'website})))

