(ns sicp-clojure.exc-1-15
  (:require [clojure.test :refer :all]
            [sicp-clojure.core :refer :all]))

(defn cube
  [x]
  (* x x x))

(def π (. Math PI))

(defn p
  [x]
  (- (* 3 x) (* 4 (cube x))))

(defn abs
  "Determine the absolute value of a number n by checking if n is larger than 0.
  If so, returns n, otherwise returns n multiplied with -1."
  [n]
  (if (> n 0)
    n
    (* n -1)))

(deftest abs-one
  (is (= (abs 1) 1)))

(deftest abs-neg-one
  (is (= (abs -1) 1)))

(defn sine
  "Performs sinus while also counting how often the function p is called in the process."
   ([angle initial cnt]
     (if (not (> (abs angle) 0.1))
       (do
         (println "sine of" initial "- p applied" cnt "times.")
         angle)
       (p (sine (/ angle 3.0) initial (inc cnt)))))
  ([angle]
   (sine angle angle 0)))

(deftest sine-eval-0
  (is (= (sine 0) 0)))

(deftest sine-eval-mx
  (is (> (sine (/ π 2)) 0.99999)))

(deftest sine-eval-pi
  (is (< (sine π) 0.0001)))

(deftest sine-eval
  (is (< (sine 12.15) -0.39)))

#_(dotimes [n 100] (sine (* n 1000)))