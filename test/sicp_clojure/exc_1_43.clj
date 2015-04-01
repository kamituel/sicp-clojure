(ns sicp-clojure.exc-1-43
  (:require [clojure.test :refer :all]
            [sicp-clojure.core :refer :all]
            [sicp-clojure.exc-1-42 :as exc-1-42]))

(defn repeated
  [f n]
  (partial (apply exc-1-42/compose (repeat n f))))

(deftest compose-test
  (is (= 625 ((repeated exc-1-42/square 2) 5))))
