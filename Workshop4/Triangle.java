
package shapes;

public class Triangle implements Shape {
	
	private double sideOne;
	private double sideTwo;
	private double sideThree;

	
	//Three-argument constructor
	public Triangle(double sideOne, double sideTwo, double sideThree) {
		this.sideOne = sideOne;
		this.sideTwo = sideTwo;
		this.sideThree = sideThree;
	
	}
	
	//Getters 
	public double getSideOne() {
		return this.sideOne;
	}
	
	public double getSideTwo() {
		return this.sideTwo;
	}
	
	public double getSideThree() {
		return this.sideThree;
	}
	
	//Override functions for this specific type of shape
	@Override
	public double perimeter() {
		return getSideOne() + getSideTwo() + getSideThree();
	}
	
	@Override
	public String toString() {
		
		 return String.format("Triangle {s1=%.2f, s2=%.2f, s3=%.2f} perimeter = %.4f\n", getSideOne(), getSideTwo(),getSideThree(),perimeter());
	}

}
