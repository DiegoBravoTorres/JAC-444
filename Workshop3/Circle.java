
package shapes;

public class Circle implements Shape {
	
	private double radius;

	//One-argument constructor
	public Circle(double radius) {
		this.radius = radius;
	}
	
	//Getters 
	public double getRadius() {
		return this.radius;
	}
	
	//Override functions for this specific type of shape
	@Override
	public double perimeter() {
		return (getRadius() * 2 * Math.PI) ;
	}
	
	@Override
	public String toString() {
		
		 return String.format("Circle {r=%.2f} perimeter = %.4f\n", getRadius(), perimeter());
	}


}
