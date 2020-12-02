package id.ac.its.dyandra119;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LabelTest {

	public static void main(String[] args) {
		
		String[] position = {"Top", "Bottom", "Right", "Left"}; 
		String[] size = {"Small 100x100", "Medium 200x200", "Large 300x300"};
		
		// Dialog box for photo position option
        int inputPosition = JOptionPane.showOptionDialog(null, 
                "Choose photo position:", 
                "Picture and Name", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                null, position, position[0]) ;
		
        // Dialog box for photo size option
        int inputSize = JOptionPane.showOptionDialog(null, 
                "Choose photo size", 
                "Picture and Name", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                null, size, size[0]) ;
        
		LabelFrame labelFrame = new LabelFrame(inputPosition, inputSize);
		labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		labelFrame.setSize(350,250); // default size of frame
		
		// if picture is Medium
		if (inputSize == 1)
			labelFrame.setSize(450,350);
		
		// if picture is Large
		if (inputSize == 2)
			labelFrame.setSize(550,450);
		
		labelFrame.setLocationRelativeTo(null); // display Frame to center of screen
		labelFrame.setVisible(true);
		

	}

}
