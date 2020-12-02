package id.ac.its.dyandra119;

public class Circle extends Shape {

	private double radius;
	
	// constructor
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}

	@Override
	public double getCircumference() {
		return Math.PI * 2.00 * this.radius;
	}

}
