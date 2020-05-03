(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'tetris.core
   :output-to "out/tetris.js"
   :output-dir "out"})
