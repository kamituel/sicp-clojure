(ns sicp-clojure.exc-1-11
  (:require [clojure.test :refer :all]
            [sicp-clojure.core :refer :all]))

(defn f-recur
  ([n]
   (if (< n 3)
     n
     (+ (f-recur (- n 1))
        (* 2 (f-recur (- n 2)))
        (* 3 (f-recur (- n 3)))))))

(defn f-iter
  "Based on an observation that:
  f(0) = 0
  f(1) = 1
  f(2) = 2
  f(3) = f(2) + 2*f(1) + 3*f(0)
  f(4) = f(3) + 2*f(2) + 3*f(1)
  ...

  So, each step, besides the first three, can be computed
  iteratively if the values of three previous steps are known.
  We init the algorithm with first three known values (0, 1, 2)
  and compute each step based on those."
  ([n]
    (if (< n 3)
      n
      (f-iter 2 1 0 n)))
  ([a b c n]
   (if (< n 3)
     a
     (f-iter (+ a (* 2 b) (* 3 c)) a b (dec n)))))

(deftest recursive
  (is (= 25 (f-recur 5)))
  (is (= 59 (f-recur 6))))


(deftest iterative
  (is (= 25 (f-iter 5)))
  (is (= 59 (f-iter 6))))
