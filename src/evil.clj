(ns evil
  (:gen-class)
  (:require [clojure.string :as str]))

(defn -main [input-file output-file]
  (spit output-file
        (-> input-file
            slurp
            (str/replace #"module\s+\S+\s*\(" "module postsynth(")
            (str/replace #"'h[0-9a-fA-F]+" (format "'h%x" (rand-int 128)))
            (str/replace #"'b\d+" (format "'b%x" (rand-int 2)))
            (str/replace #"'d\d+" (format "'h%d" (rand-int 128)))
            (str/replace #"&" "|")
            (str/replace #"posedge" "negedge"))))
