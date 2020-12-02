package id.ac.its.nur028;

public class IsoscelesTriangle extends Triangle {

	public IsoscelesTriangle(double base, double height) {
		super(base, height);
	}

	@Override
	public double getCircumference() {
		double base = super.base / 2;
		return 2 * super.getHypothenuse(base, super.height) + super.base;
	}

}
