package id.ac.its.nur028;

import javax.swing.*;

public class ShapeTest {
	public static void main(String[] args) {
		String[] options = {"Isosceles Triangle", "Right Triangle"};
		
		int input = JOptionPane.showOptionDialog(null, 
				"Choose one 2D Shape", 
				"Area and Circumference", 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE, 
				null, options, options[0]);
		
		if(input == 0) {
			JTextField base = new JTextField();
			JTextField height = new JTextField();
			
			Object[] fields = {"Insert base", base, 
					"Insert height", height};
			
			int option = JOptionPane.showConfirmDialog(null, fields, 
					"Isosceles Triangle", 
					JOptionPane.OK_CANCEL_OPTION, 
					JOptionPane.QUESTION_MESSAGE);
			
			if(option == JOptionPane.OK_OPTION) {
				double Base = Double.parseDouble(base.getText());
				double Height = Double.parseDouble(height.getText());
				
				if(Base <= 0 || Height <= 0) {
					errorWindow("All input must be positive");
					return;
				}
				
				IsoscelesTriangle isosceles_triangle = new IsoscelesTriangle(Base, Height);
				
				double area = isosceles_triangle.getArea();
				double circumference = isosceles_triangle.getCircumference();
				
				JOptionPane.showMessageDialog(null, 
						"Area = " + area + "\nCircumference = " + circumference, 
						"Result Isosceles Triangle", JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		else if (input == 1) {
			JTextField base1 = new JTextField();
			JTextField height1 = new JTextField();
			
			Object[] fields = {"Insert base", base1, 
					"Insert height", height1};
			
			int option = JOptionPane.showConfirmDialog(null, fields, 
					"Right Triangle", 
					JOptionPane.OK_CANCEL_OPTION, 
					JOptionPane.QUESTION_MESSAGE);
			
			if(option == JOptionPane.OK_OPTION) {
				double Base1 = Double.parseDouble(base1.getText());
				double Height1 = Double.parseDouble(height1.getText());
				
				if(Base1 <= 0 || Height1 <= 0) {
					errorWindow("All input must be positive");
					return;
				}
				
				RightTriangle right_triangle = new RightTriangle(Base1, Height1);
				
				double area = right_triangle.getArea();
				double circumference = right_triangle.getCircumference();
				
				JOptionPane.showMessageDialog(null, 
						"Area = " + area + "\nCircumference = " + circumference, 
						"Result Right Triangle", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
	
	protected static void errorWindow (String args) {
		JOptionPane.showMessageDialog(null, args, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
