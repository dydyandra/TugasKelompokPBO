package id.ac.its.nur028;

import javax.swing.*;
import java.awt.*;

public class PhotoFrame extends JFrame {

	private final JLabel label;
	
	public PhotoFrame(int select, int size) {
		super("Nur Hidayati 028");
		setLayout(new FlowLayout());
		Icon picture = new ImageIcon(getClass().getResource("MyPhoto.jpg")); // set alamat dan nama file gambar
		
		// Resize gambar agar fix ke dalam window
		Image image = ((ImageIcon)picture).getImage();
	
		Image temp = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // default ukuran small 100x100
		
		// memilih ukuran gambar
		if(size == 1)
			temp = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); // ukuran medium 200x200
		else if(size == 2)
			temp = image.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH); // ukuran large 300x300
		picture = new ImageIcon(temp);
		
		// membuat label
		label = new JLabel();
		label.setText("Nur Hidayati - 05111940000028"); // set text
		label.setIcon(picture); // set picture
		label.setToolTipText("me"); // set alt
		label.setHorizontalTextPosition(SwingConstants.CENTER); // set posisi text agar di tengah
		
		if(select == 0) { // posisi gambar di atas
			label.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		else if(select == 1) { // posisi gambar di bawah
			label.setVerticalTextPosition(SwingConstants.TOP);
		}
		else if(select == 2) { // posisi gambar di kanan
			label.setHorizontalTextPosition(SwingConstants.LEFT);
		}
		else if(select == 3) { // posisi gambar di kiri
			label.setHorizontalTextPosition(SwingConstants.RIGHT);
		}
		add(label); // memasukkan label ke dalam JFrame
	}
}
