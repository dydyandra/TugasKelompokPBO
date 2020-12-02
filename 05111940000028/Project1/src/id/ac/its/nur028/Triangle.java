package id.ac.its.nur028;

public abstract class Triangle extends Shape {

	protected double base;
	protected double height;
	
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	@Override
	public double getArea() {
		return 0.5 * this.base * this.height;
	}
	
}
