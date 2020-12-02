package id.ac.its.dyandra119;

import java.awt.FlowLayout; // for component arrangements
import java.awt.Image; // interface to manipulate image (such as size)

import javax.swing.JFrame; // basic window features
import javax.swing.JLabel; // display text and image
import javax.swing.SwingConstants; // constants used with Swing
import javax.swing.Icon; // interface to manipulate image
import javax.swing.ImageIcon; // loads images

public class LabelFrame extends JFrame {
	
	private final JLabel label;
	
	//LabelFrame constructor adds Jlabel to JFrame
	public LabelFrame(int choice, int size)
	{
		super("Dyandra Paramitha 05111940000119");
		setLayout(new FlowLayout()); // set frame layout
		
		//get photo
		Icon photo = new ImageIcon(getClass().getResource("pasfoto.jpg"));
		
		// convert type Icon into Image
		Image img = ((ImageIcon)photo).getImage();
		
		// Default size of picture (100x100)
		Image temp = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		
		// change size for Medium (200x200)
		if (size == 1)
			temp = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		
		// change size for Large (300 x 300)
		if (size == 2)
			temp = img.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
		
	
		photo = new ImageIcon(temp);
		
		// Jlabel constructor with no arguments
		label = new JLabel();
		label.setText("Dyandra Paramitha 05111940000119");
		label.setIcon(photo);
		label.setToolTipText("Dyandra");
		label.setHorizontalTextPosition(SwingConstants.CENTER); // default text position
		
		// Options of text positions 
		// if text position is below the picture
		if (choice == 0) { 
			label.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		
		// if text position is above the picture
		if (choice == 1)
		{
			label.setVerticalTextPosition(SwingConstants.TOP);
		}
		
		// if text position is in left of picture
		if (choice == 2)
		{
			label.setHorizontalTextPosition(SwingConstants.LEFT);
		}
		
		// if text position is in right of picture
		if (choice == 3)
		{
			label.setHorizontalTextPosition(SwingConstants.RIGHT);
		}
		
		add(label);
	}
	

}
