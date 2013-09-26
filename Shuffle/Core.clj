(ns Core)

(use '[clojure.string :only (join split replace-first split-lines)])

(defn mix-up-content [sc]
  (loop [old sc
         new ""]
    (let [pick-pos (rand-int (count old))
          c (get old pick-pos)]
      (if (= old "")
          new
          (recur (replace-first old (str c) "") (str new c))))))

(defn word-without-bound [w]
  (apply str (butlast (rest w))))

(defn is-lastchar-special? [w]
  (or (not (nil? w)) (not (Char/IsLetterOrDigit (last w)))))

(defn shuffle-word [w]
  (let [special? (is-lastchar-special? w)
        cw (if special? (apply str (butlast w)) w )
        sw (str (first cw)
                (mix-up-content (word-without-bound cw))
                (last (rest cw)))
        rw (if special? (str sw (last w)) sw)]
    rw))

(defn to-words [s]
  (split s #"\s"))

(defn shuffle-paragraph [s]
  (let [ws (to-words s)
        mws (map shuffle-word ws)]
    (apply str (interpose " " mws))))

(defn shuffle-content [s]
  (let [ps (split-lines s)
        mps (map shuffle-paragraph ps)]
    (apply str (interpose "\r\n" mps))))

(defn shuffle-file-content [in-file out-file]
  (let [s (slurp in-file)]
    (spit out-file  (shuffle-content s))))