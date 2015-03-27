(ns sicp-clojure.exc-1-16
  (:require [clojure.test :refer :all]
            [sicp-clojure.core :refer :all]))

(defn fast-expt
  ([b n]
   (fast-expt b n 1))
  ([b n a]
   (cond
    (zero? n) a
    (even? n) (fast-expt (* b b) (/ n 2) a)
    :else (fast-expt b (dec n) (* a b)))))


(deftest fast-expt-test
  (mapv (fn [[b n] result]
          (is (= result (fast-expt b n))))
        [[2 10] [3 4] [1 0]]
        [1024 81 1]))
