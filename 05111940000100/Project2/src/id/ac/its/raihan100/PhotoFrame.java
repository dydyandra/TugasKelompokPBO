package id.ac.its.raihan100;
import javax.swing.* ;
import java.awt.* ;


public class PhotoFrame extends JFrame {
	private final JLabel label ;
	
	public PhotoFrame(int choice, int size) {
		super("Muhammad Raihan 100") ;
		setLayout(new FlowLayout()) ;
		// Set Alamat dan nama file gambar (Untuk foto bisa disesuaikan)
		Icon pict = new ImageIcon(getClass().getResource("MyPhoto.jpg")) ;
		
		// Me-resize gambar agar fit kedalam window
		Image img = ((ImageIcon)pict).getImage() ;
		
		// Default ukuran 100 x 100 (Small)
		Image temp = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH) ;
		
		// Memilih Size Gambar
		if (size == 1)
			temp = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH) ;
		else if (size == 2)
			temp = img.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH) ;
		
		pict = new ImageIcon(temp) ;
		
        // Membuat Label
		label = new JLabel() ;
		label.setText("Muhammad Raihan - 05111940000100") ; // Teks
		label.setIcon(pict) ; // Gambar
		label.setToolTipText("Me") ; // alt
		label.setHorizontalTextPosition(SwingConstants.CENTER) ; // Default posisi teks di tengah
		
		if (choice == 0) { // Posisi gambar di atas
			label.setVerticalTextPosition(SwingConstants.BOTTOM) ;
		}
		else if (choice == 1) { // Posisi gambar di bawah
			label.setVerticalTextPosition(SwingConstants.TOP) ;
		}
		else if (choice == 2) { // Posisi gambar di kanan
			label.setHorizontalTextPosition(SwingConstants.LEFT) ;
		}
		else if (choice == 3) { // Posisi gambar di kiri
			label.setHorizontalTextPosition(SwingConstants.RIGHT) ;
		}
		// Memasukkan Label kedalam JFrame
		add(label) ;
	}
}
