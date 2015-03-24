(ns sicp-clojure.exc-1-1
  (:require [clojure.test :refer :all]
            [sicp-clojure.core :refer :all]))

(deftest tenIsTen
  (is (= 10 10)))

(deftest flatAddition
  (is (= 12 (+ 5 3 4))))

(deftest flatSubtraction
  (is (= 8 (- 9 1))))

(deftest division
  (is (= 3 (/ 6 2))))

(deftest mathMix
  (is (= 6
    (+ (* 2 4) (- 4 6)))))

(deftest variableAssignmentAndUsage
  (def a 3)
  (def b (+ a 1))

  (is (= 19
    (+ a b (* a b))))

  (not (= a b))

  ;Conditions
  (is (= b (if (and (> b a) (< b (* a b)))
    b a)))

  (is (= 6 (cond
              (> 2 1) 6
              (= b 4) (+ 6 7 a)
              :else 25)))

  (is (= 6
    (+ 2 (if (> b a) b a))))

  (is (= 16
    (* (cond
        (> a b) a
        (< a b) b
        :else -1)
      (+ a 1)))))
