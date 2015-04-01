(ns sicp-clojure.exc-1-44
  (:require [clojure.test :refer :all]
            [sicp-clojure.core :refer :all]
            [sicp-clojure.exc-1-43 :as exc-1-43])
  (:import java.lang.Math))

(defn f
  "Some polynomial to smooth"
  [x]
  (+ (* 3 x x x)
     (* -1 x x)
     (* -2 x)
     1))

(defn average
  [& xs]
  (/ (reduce + xs) (count xs)))

;; dx used by the smoothing function.
(def ^:dynamic *dx* 0.0001)

(defn smooth
  [f]
  (fn [x]
    (average (f (- x *dx*))
             (f x)
             (f (+ x *dx*)))))

(defn smooth-n
  [n f]
  ((exc-1-43/repeated smooth n) f))

(deftest smooth-test
  ; Redefining dx, so the expected value is sane.
  (binding [*dx* 1]
    (is (= 1/3 ((smooth f) 0)))))

(deftest smooth-n-test
  (is (= ((smooth f) 2) ((smooth-n 1 f) 2)))
  (is (= ((smooth (smooth f)) 2) ((smooth-n 2 f) 2))))


