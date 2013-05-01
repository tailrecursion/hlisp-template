(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: add description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[tailrecursion/lein-hlisp "2.0.3-SNAPSHOT"]]
  :dependencies [[tailrecursion/hlisp-macros "1.0.0"]
                 [tailrecursion/hlisp-reactive "1.0.2-SNAPSHOT"]
                 [tailrecursion/hlisp-util "0.1.0-SNAPSHOT"]]
  :source-paths ["src/clj" "src/cljs"]
  :eval-in :leiningen
  :hlisp {:html-src "src/html"
          :html-out "resources/public"
          :pretty-print false
          :cljsc-opts {:warnings true
                       :pretty-print false
                       :optimizations :whitespace}})
