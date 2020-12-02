package id.ac.its.raihan100;

public class Rhombus extends Shape {
	
	private double firstDiagonal ;
	private double secondDiagonal ;

	public Rhombus(double firstDiagonal, double secondDiagonal) {
		this.firstDiagonal = firstDiagonal;
		this.secondDiagonal = secondDiagonal;
	}
	
	@Override
	public double getArea() {
		return (firstDiagonal * secondDiagonal) / 2 ;
	}

	@Override
	public double getCircumference() {
		return 4 * super.getHypotenuse(firstDiagonal / 2, secondDiagonal / 2) ;
	}

}
