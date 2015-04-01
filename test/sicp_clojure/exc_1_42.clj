(ns sicp-clojure.exc-1-42
  (:require [clojure.test :refer :all]
            [sicp-clojure.core :refer :all]))

(defn square
  [x]
  (* x x))

(defn compose2
  "Composes two functions"
  [f g]
  (fn [x]
    (f (g x))))

(defn compose
  "Composes any number of functions"
  [& f]
  (fn [x]
    (reduce #(%2 %1) x (reverse f))))

(deftest compose-test
  (is (= 49  ((compose2 square inc) 6)))
  (is (= 49  ((compose  square inc) 6)))
  (is (= 100 ((compose  square inc square inc) 2))))
