(System.Reflection.Assembly/LoadWithPartialName "System.Windows.Forms")

(ns program
  (:import [System.Windows.Forms Application])
  (:gen-class)
  (:require ShuffleGUI)
)

(defn -main [& args]
			(Application/EnableVisualStyles)
			(Application/SetCompatibleTextRenderingDefault false)
			(Application/Run (ShuffleGUI/createForm1))
)