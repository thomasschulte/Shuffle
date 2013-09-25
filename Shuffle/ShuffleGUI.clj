(ns ShuffleGUI
  (:import [System.Windows.Forms Form Button TextBox AnchorStyles])
  (:import [System.Drawing Size Point])
)

(defn createForm1 []
  (let [form (Form.)
	    btnShuffle (Button.)
        txtFrom (TextBox.)
        txtTo (TextBox.)
       ]
    
    (doto btnShuffle
      (.set_Anchor (Enum/ToObject AnchorStyles 9))
      (.set_Location (Point. 10 10))
      (.set_Name "btnShuffle")
;      (.set_Anchor (bit-or AnchorStyles/Top AnchorStyles/Right))
;      (.set_Location (Point. 615 12))
      (.set_Size (Size. 75 23))
      (.set_Text "Shuffle")
      (.add_Click 
        (gen-delegate EventHandler [sender args]
	      (.Close form))))

    (doto txtFrom
      (.set_Name "txtFrom")
      (.set_Location (Point. 50 50))
      (.set_Size (Size. 100 20))
      (.set_Multiline true)
      (.set_Text "Das ist der Start Text mit nicht so ganz langen Wörtern")
      )

    (doto txtTo
      (.set_Name "txtTo")
      (.set_Location (Point. 50 200))
      (.set_Size (Size. 100 50))
      (.set_Multiline true)
      (.set_Text "Das ist der Start Text mit nicht so ganz langen Wörtern")
      )
   
    (doto (.Controls form)
      (.Add btnShuffle)
      (.Add txtFrom)
      (.Add txtTo)
      )
    
    (doto form
      (.set_Text "Shuffle GUI")
      (.set_Size (Size. 702 447))
      (.ResumeLayout false)
      (.PerformLayout)
      )

    form
  )
)