(ns leiningen.new.hlisp
  (:require
    [clojure.java.io :as io]
    [clojure.string :as string]
    [leiningen.new.templates :as t]))

(def render (t/renderer "hlisp"))

(def proj-dir (io/file (System/getProperty "leiningen.original.pwd")))

(defn unpack
  [name-proj name-in name-out]
  (let [p  (string/join "/" ["leiningen" "new" "hlisp" name-in])
        i  (io/resource p)
        o  (io/file proj-dir name-proj name-out)
        _  (io/make-parents o)
        is (io/input-stream i)
        os (io/output-stream o)]
    (io/copy is os)
    (.flush os)))

(defn hlisp
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :ns-name (t/sanitize-ns name)
              :sanitized (t/name-to-path name)
              :year (t/year)}]
    (t/->files data
               ["project.clj" (render "project.clj" data)]
               ["README.md" (render "README.md" data)]
               ["src/html/index.html" (render "index.html" data)]
               ["src/cljs/{{name}}/state.cljs" (render "state.cljs" data)]
               ["src/static/css/main.css" (render "main.css")])
    (mapv #(apply unpack (:sanitized data) %)
          [["favicon.ico" "src/static/favicon.ico"] 
           ["kitten1.jpg" "src/static/img/kitten1.jpg"] 
           ["kitten2.jpg" "src/static/img/kitten2.jpg"]
           ["kitten3.jpg" "src/static/img/kitten3.jpg"]
           ["kitten4.jpg" "src/static/img/kitten4.jpg"]])))
