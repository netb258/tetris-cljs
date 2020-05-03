(defproject tetris "0.1.0-SNAPSHOT"
  :description "Tetris written in ClojureScript."
  :url "https://github.com/netb258/tetris-cljs"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.10.339" :scope "provided"]
                 [quil "2.7.1"]]
  :jvm-opts ^:replace ["-Xmx1g"]
  :plugins [[lein-npm "0.6.2"]]
  :npm {:dependencies [[source-map-support "0.4.0"]]}
  :source-paths ["src" "target/classes"]
  :clean-targets [:target-path "out" "release"]
  :target-path "target")
