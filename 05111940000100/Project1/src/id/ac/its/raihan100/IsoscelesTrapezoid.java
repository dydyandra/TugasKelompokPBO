package id.ac.its.raihan100;
import static java.lang.Math.abs ;

public class IsoscelesTrapezoid extends Shape {

	private double firstParallel ;
	private double secondParallel ;
	private double height ;
	
	public IsoscelesTrapezoid(double firstParallel, double secondParallel, double height) {
		this.firstParallel = firstParallel;
		this.secondParallel = secondParallel;
		this.height = height;
	}

	@Override
	public double getArea() {
		return (firstParallel + secondParallel) * height / 2 ;
	}

	@Override
	public double getCircumference() {
		double base = abs(firstParallel - secondParallel) ;
		return firstParallel + secondParallel + 2 * super.getHypotenuse(base / 2, height) ;
	}

}
