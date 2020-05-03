;; You could say that the game of tetris is all about matrix manipulations and that is exactly what this module does.
;; The functions here are pure, mostly they take a matrix and returns a transformed matrix.
(ns tetris.matrix
  (:require [clojure.string :as s]
            [tetris.graphics :as g]))

(defn get-empty-matrix
  "Contract: nil -> vector<vector>"
  []
  (into [] (take 22 (repeat g/EMPTY-LINE))))

(defn insert-piece-row
  "Contract: vector<string> vector<string> int -> vector<string>"
  [piece-row matrix-row position]
  (let [end-position (+ position (count piece-row))
        leading-space (take-while #(= "." %) piece-row)
        trailing-space (drop-while #(not= "." %) (drop-while #(= "." %) piece-row))
        before-piece (subvec matrix-row 0 (+ position (count leading-space)))
        piece (filter #(not= "." %) piece-row)
        after-piece (subvec matrix-row (- end-position (count trailing-space)))]
    (into []
          (concat
            before-piece piece after-piece))))

;; Throws an IndexOutOfBoundsException, if the row/col are outside the matrix.
(defn insert-piece
  "Contract: vector<vector> vector<vector> int int -> vector<vector>"
  [piece matrix row col]
  (let [num-piece-rows (count piece)
        rows-before-piece (subvec matrix 0 row)
        rows-for-piece (subvec matrix row (+ row num-piece-rows))
        rows-after-piece (subvec matrix (+ num-piece-rows row))
        piece-inserted (map #(insert-piece-row %1 %2 col) piece rows-for-piece)]
    (into [] (concat rows-before-piece piece-inserted rows-after-piece))))
