(ns sicp-clojure.exc-1-3
  (:require [clojure.test :refer :all]
            [sicp-clojure.core :refer :all]))

; Define a procedure that takes three numbers
; as arguments and returns the sum of the squares of the two
; larger numbers.

(defn performProcedure
  "Takes three numbers, sums the square of the two larger numbers."
  [a b c]
  (let [sorted (sort [a b c])
        larger (drop 1 sorted)]
    (apply + (map * larger larger))))

(deftest applies-square-and-add
  (is (= 653 (performProcedure 10 22 13))))
