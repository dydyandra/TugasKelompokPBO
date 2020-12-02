package id.ac.its.nur028;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public abstract class Shape {
	
	public abstract double getArea();
	public abstract double getCircumference();
	
	public double getHypothenuse(double a, double b) {
		double hypothenuse = sqrt(pow(a, 2) + pow(b,2));
		return hypothenuse;
	}
}
