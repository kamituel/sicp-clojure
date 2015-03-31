(ns sicp-clojure.exc-1-29
  (:require [clojure.test :refer :all]
            [sicp-clojure.core :refer :all]))

(defn cube
  [x]
  (* x x x))

(defn sum
  [term a next b]
  (if (> a b)
    0
    (+ (term a)
       (sum term (next a) next b))))

(defn integral
  "Computes integral of a function using numerical approximation."
  [f a b dx]
  (letfn [(add-dx [x] (+ x dx))]
    (* (sum f (+ a (/ dx 2.0)) add-dx b)
       dx)))

(defn simpson
  "Computes integral of a function using Simpson's Rule."
  [rounding f a b n]
  ; Rounding fn can be used to force to coerce computation
  ; from ratios to floating point arithmetic.
  (let [h (rounding (/ (- b a) n))
        y #(rounding (f (+ a (* % h))))
        y-series (map #(y %) (range 1 n))]
    (* (/ h 3)
       (+ (y 0)
          (y n)
          (reduce + (map * y-series (cycle [4 2])))))))

(defn in-range
  [expected x delta]
  (>= delta (Math/abs (- expected x))))

(deftest rational-simpson
  (is (= 1/4 (simpson identity cube 0 1 10)))
  (is (= 4015/4 (simpson identity cube 3 8 10)))
  (is (in-range 0.25 (simpson float cube 0 1 10) 0.001)))

(deftest rational-integral
  (is (in-range 0.25 (integral cube 0 1 0.01) 0.001))
  (is (in-range 1003.75 (integral cube 3 8 0.01) 0.001)))
