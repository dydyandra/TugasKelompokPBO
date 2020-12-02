package id.ac.its.dyandra119;

public class Rectangle extends Shape {
	
	private double height;
	private double width;
	
	// constructor
	public Rectangle(double height, double width) {
		super();
		this.height = height;
		this.width = width;
	}

	@Override
	public double getArea() {
		
		return this.width * this.height;
	}
	
	@Override
	public double getCircumference() {
		
		return (2.00 * this.width) + (2.00 * this.height);
	}
	
	
	
	

}
