package id.ac.its.dyandra119;
import javax.swing.*;
 
public class ShapeGUI {
 
    public static void main(String[] args) {
        
        String[] options = {"Circle", "Rectangle"} ;
        
        int input = JOptionPane.showOptionDialog(null, 
                "Choose one 2D Shape", 
                "Area and Circumference", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                null, options, options[0]) ;
        
        if (input == 0) {
            JTextField Radius = new JTextField() ;
            
            Object[] fields = {
                    "Insert Radius", Radius
            } ;
            
            int option = JOptionPane.showConfirmDialog(null, fields, 
                    "Circle", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if (option == JOptionPane.OK_OPTION) {
                double r = Double.parseDouble(Radius.getText()) ;
                
                if (r <= 0) {
                	errorWindow("All input must be positive!");
                	return;
                }
                	

                Circle circle = new Circle(r) ;
                
                double circum = circle.getCircumference() ;
                double area = circle.getArea() ;
                
                JOptionPane.showMessageDialog(null, 
                		"Area : " + area + "\nCircumference : " + circum,
                        "Result", JOptionPane.PLAIN_MESSAGE);
                
            }
        }
        if (input == 1) {
            JTextField Height = new JTextField() ;
            JTextField Width= new JTextField() ;
            
            Object[] fields = {
                    "Insert Height", Height,
                    "Insert Width", Width
            } ;
            
            int option = JOptionPane.showConfirmDialog(null, fields, 
                    "Rectangle", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if (option == JOptionPane.OK_OPTION) {
                double height = Double.parseDouble(Height.getText()) ;
                double width = Double.parseDouble(Width.getText()) ;
                Rectangle rectangle = new Rectangle(height, width) ;
                
                if (height <= 0 || width <=0) {
                	errorWindow("All input must be positive!");
                	return;
                }
                
                double circum = rectangle.getCircumference() ;
                double area = rectangle.getArea() ;
                
                JOptionPane.showMessageDialog(null, 
                		"Area : " + area + "\nCircumference : " + circum,
                        "Result", JOptionPane.PLAIN_MESSAGE);
                
            }
        }
        
        
    }
    
    protected static void errorWindow (String args) {
    	JOptionPane.showMessageDialog(null, args,
    			"Error", JOptionPane.ERROR_MESSAGE);
    }
 
}