package id.ac.its.raihan100;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public abstract class Shape {

	public abstract double getArea() ;
	public abstract double getCircumference() ;

	public double getHypotenuse(double a, double b) {
		double pyth = pow(a, 2) + pow(b, 2) ; 
		return sqrt(pyth) ;
	}
}
