
package shapes;

public class Circle implements Shape {
	
	private double radius;
	
	// Lambda function to get area
	private GetArea areaOfCircle = () -> this.radius * this.radius * Math.PI;

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
	
	//Getter function to pass area using lambda 
	public double getArea(){
		return areaOfCircle.calculateArea();
	}
	
	@Override
	public String toString() {
		
		 return String.format("Circle {r=%.2f} Perimeter = %.4f Area = %.2f\n", getRadius(), perimeter(), getArea());
	}


}
