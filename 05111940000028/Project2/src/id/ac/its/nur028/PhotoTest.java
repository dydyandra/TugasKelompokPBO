package id.ac.its.nur028;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PhotoTest {

	public static void main(String[] args) {
		// memilih posisi gambar yang akan ditampilkan 
		String[] options1 = {"Top", "Bottom", "Right", "Left"};
		String[] options2 = {"Small 100x100", "Medium 200x200", "Large 300x300"};
		
		// Option dialog box untuk memilih posisi gambar yang akan ditampilkan 
		int input1 = JOptionPane.showOptionDialog(null, 
				"Choose Picture Position", 
				"Picture and Identity", 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE, 
				null, options1, options1[0]);
		
		int input2 = JOptionPane.showOptionDialog(null, 
				"Choose Picture Size", 
				"Picture and Identity", 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE, 
				null, options2, options2[0]);
		
		// Menampilkan JFrame berisi gambar dan text
		PhotoFrame photo_frame = new PhotoFrame(input1, input2); // constructor
		photo_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		photo_frame.setSize(350, 250); // default ukuran JFrame small 100x100
		
		if(input2 == 1) // jika yg diminta gambar berukuran medium
			photo_frame.setSize(450, 350); // maka ukuran JFrame 450x350
		else if(input2 == 2) // jika yg diminta gambar berukuran large
			photo_frame.setSize(550, 450); // maka ukuran JFrame 550x450
		
		photo_frame.setLocationRelativeTo(null); // posisi window akan selalu muncul di tengah
		photo_frame.setVisible(true);
	}
}
