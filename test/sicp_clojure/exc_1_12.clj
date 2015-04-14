(ns sicp-clojure.exc-1-12
  (:require [clojure.test :refer :all]
            [sicp-clojure.core :refer :all]))

; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
; Recursive approach

(defn pascal
 [n]
   (if (= 1 n)
     [[1]]
     ; pyramid - the complete pyramid for n - 1
     ; prev - single level of pyramid for n - 1
     (let [pyramid (pascal (dec n))
           prev (last pyramid)]
       (conj pyramid
             (into [] (map +
                           (into [0] prev)
                           (into prev [0])))))))


(deftest pascal-triangle
  (is (= [[    1    ]
          [   1 1   ]
          [  1 2 1  ]]
         (pascal 3)))

  (is (= [[    1    ]
          [   1 1   ]
          [  1 2 1  ]
          [ 1 3 3 1 ]
          [1 4 6 4 1]]
         (pascal 5))))



; ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
; Approach with separated functions

; Returns one value based on values of prev row (same and prev index)
(defn get-new-value
  [i itm r]
  (let [res (if (zero? i)
              itm
              (+ (get r (- i 1)) itm))]
    res))

; Returns a new row based on previous row
(defn get-new-row
  [r]
  (vec (flatten (cons (map-indexed (fn [i itm] (get-new-value i itm r)) r) [(last r)]))))

; Returns the accumulated pyramid
(defn pascal-2
  [cnt]
  (let [pyramid (take cnt (iterate get-new-row [1]))]
    (vec pyramid)))

(deftest pascal-triangle-2
  (is (= (pascal-2 4)
         [[1]
          [1 1]
          [1 2 1]
          [1 3 3 1]]))

  (is (= (pascal-2 9)
         [[                1                ]
          [              1   1              ]
          [            1   2   1            ]
          [          1   3   3   1          ]
          [        1   4   6   4   1        ]
          [      1   5   10  10  5   1      ]
          [    1   6   15  20  15  6   1    ]
          [  1   7   21  35  35  21  7   1  ]
          [1   8  28   56  70  56  28  8   1]])))

