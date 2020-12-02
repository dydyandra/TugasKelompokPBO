package id.ac.its.raihan100;
import javax.swing.* ;

public class PhotoTest {

	public static void main(String[] args) {
		// Pilihan Posisi Gambar yang akan ditampilkan
		String[] options1 = {"Top", "Bottom", "Right", "Left"} ;
		String[] options2 = {"Small 100x100", "Medium 200x200", "Large 300x300"} ;
		
		// Dialog Option Box untuk memilih posisi gambar
		int input1 = JOptionPane.showOptionDialog(null, 
				"Choose Picture Position", 
				"Picture and Text", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]) ;
		
		int input2 = JOptionPane.showOptionDialog(null, 
				"Choose Picture Size", 
				"Picture and Text", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]) ;
		
		// Menampilkan JFrame berisi gambar dan teks
		PhotoFrame frame = new PhotoFrame(input1, input2) ; // Constructor
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		frame.setSize(350, 250) ; // Ukuran JFrame
		
		if (input2 == 1) 
			frame.setSize(450, 350) ;
		else if (input2 == 2) 
			frame.setSize(550, 450) ;
		
		frame.setLocationRelativeTo(null) ; // Posisi Window agar muncul selalu di tengah screen
		frame.setVisible(true) ;

	}

}
