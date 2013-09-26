(ns ShuffleGUI
  (:use [Core])
  (:import [System.Windows.Forms Form Button TextBox AnchorStyles FormBorderStyle])
  (:import [System.Drawing Size Point Font]))

(defn createForm1 []
  (let [form (Form.)
	    btnShuffle (Button.)
        txtFrom (TextBox.)
        txtTo (TextBox.)]
    
    (doto btnShuffle
      (.set_Location (Point. 615 215))
      (.set_Name "btnShuffle")
      (.set_Size (Size. 75 23))
      (.set_Text "Shuffle")
      (.add_Click 
        (gen-delegate EventHandler [sender args]
          (let [t (.get_Text txtFrom)
                t (shuffle-content t)]          
            (.set_Text txtTo t)))))

    (doto txtFrom
      (.set_Name "txtFrom")
      (.set_Location (Point. -1 1))
      (.set_Size (Size. 610 208))
      (.set_Multiline true)
      (.set_Font (Font. "Microsoft Sans Serif", 18.0))
      (.set_Text "Das ist der ziemlich kurze Start Text"))

    (doto txtTo
      (.set_Name "txtTo")
      (.set_Location (Point. -1 215))
      (.set_Size (Size. 610 227))
      (.set_Multiline true)
      (.set_Font (Font. "Microsoft Sans Serif", 18.0))
      (.set_Text ""))
   
    (doto (.Controls form)
      (.Add btnShuffle)
      (.Add txtFrom)
      (.Add txtTo))
    
    (doto form
      (.set_Text "Shuffle GUI")
      (.set_Size (Size. 702 447))
      (.set_FormBorderStyle FormBorderStyle/FixedSingle)
      (.ResumeLayout false)
      (.PerformLayout))

    form))