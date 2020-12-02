package id.ac.its.nur028;

public class RightTriangle extends Triangle {

	public RightTriangle(double base, double height) {
		super(base, height);
	}

	@Override
	public double getCircumference() {
		return super.base + super.height + super.getHypothenuse(super.base, super.height);
	}
	
}
