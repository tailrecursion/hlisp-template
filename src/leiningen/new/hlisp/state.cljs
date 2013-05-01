(ns {{name}}.state
  (:require-macros
    [tailrecursion.javelin.macros :refer [cell]])
  (:require
    [hlisp.util             :as u]
    [hlisp.reactive         :as r]
    [tailrecursion.javelin  :as j]))

(def stem-cell
  (cell '[{:views 0 :caption "first kitten"  :url "img/kitten1.jpg"}
          {:views 0 :caption "second kitten" :url "img/kitten2.jpg"}
          {:views 0 :caption "third kitten"  :url "img/kitten3.jpg"}
          {:views 0 :caption "fourth kitten" :url "img/kitten4.jpg"}]))

(defn r-stem
  [things i]
  [(cell (-> (nth things i) :views))
   (cell (-> (nth things i) :url))
   (cell (-> (nth things i) :caption))])

(def loop-kittens
  (r/thing-looper stem-cell r-stem))

(def current-kitten (cell 0))

(defn view-kitten!
  [idx]
  (let [next-kitten (mod idx (count @stem-cell))]
    (swap! stem-cell update-in [next-kitten :views] inc)
    (reset! current-kitten next-kitten)))
