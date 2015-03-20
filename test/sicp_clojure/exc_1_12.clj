(ns sicp-clojure.exc-1-12
  (:require [clojure.test :refer :all]
            [sicp-clojure.core :refer :all]))

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
