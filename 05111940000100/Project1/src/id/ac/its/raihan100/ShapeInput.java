package id.ac.its.raihan100;
import javax.swing.*;

public class ShapeInput {

	public static void main(String[] args) {
		
		String[] options = {"Isosceles Trapezoid", "Rhombus"} ;
		
		int input = JOptionPane.showOptionDialog(null, 
				"Choose one 2D Shape", 
				"Area and Circumference", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) ;
		
		if (input == 0) {
			JTextField P1 = new JTextField() ;
			JTextField P2 = new JTextField() ;
			JTextField H = new JTextField() ;
			
			Object[] fields = {
					"Insert First Parallel", P1,
					"Insert Second Parallel", P2,
					"Insert Height", H
			} ;
			
			int option = JOptionPane.showConfirmDialog(null, fields, 
					"Isosceles Trapezoid", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (option == JOptionPane.OK_OPTION) {
				double p1 = Double.parseDouble(P1.getText()) ;
				double p2 = Double.parseDouble(P2.getText()) ;
				double h = Double.parseDouble(H.getText()) ;
				
				if (p1 <= 0 || p2 <= 0 || h <= 0) {
					errorWindow("All Input must be positive") ;
					return ;
				}
				
	            IsoscelesTrapezoid trapezoid = new IsoscelesTrapezoid(p1, p2, h) ;
	            
	            double circum = trapezoid.getCircumference() ;
	            double area = trapezoid.getArea() ;
	            
	            JOptionPane.showMessageDialog(null, "Area : " + area + "\nCircumference : " + circum,
	            		"Result", JOptionPane.PLAIN_MESSAGE);
	            
	        }
		}
		else if (input == 1) {
			JTextField D1 = new JTextField() ;
			JTextField D2 = new JTextField() ;
			
			Object[] fields = {
					"Insert First Diagonal", D1,
					"Insert Second Diagonal", D2
			} ;
			
			int option = JOptionPane.showConfirmDialog(null, fields, 
					"Rhombus", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (option == JOptionPane.OK_OPTION) {
				double d1 = Double.parseDouble(D1.getText()) ;
				double d2 = Double.parseDouble(D2.getText()) ;
				
				if (d1 <= 0 || d2 <= 0) {
					errorWindow("All Input must be positive") ;
					return ;
				}
				
	            Rhombus rhombus = new Rhombus(d1, d2) ;
	            
	            double circum = rhombus.getCircumference() ;
	            double area = rhombus.getArea() ;
	            
	            JOptionPane.showMessageDialog(null, "Area : " + area + "\nCircumference : " + circum,
	            		"Result", JOptionPane.PLAIN_MESSAGE);
	            
	        }
		}
	}
	
	protected static void errorWindow(String args) {
		JOptionPane.showMessageDialog(null, args,
        		"Error", JOptionPane.ERROR_MESSAGE);
	}

}
