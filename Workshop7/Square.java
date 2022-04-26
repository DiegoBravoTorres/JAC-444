
package shapes;

public class Square implements Shape {
	
	private double length;
	
	// Lambda function to get area
	private GetArea areaOfSquare = () -> this.length * this.length;
	
	//One-argument constructor
	public Square(double length) {
		this.length = length;

	}
	
	//Getter
	public double getLength() {
		return this.length;
	}
	
	// Override functions for this specific type of shape
	@Override
	public double perimeter() {
		return getLength() * 4;
	}
	
	//Getter function to pass area using lambda 
	public double getArea(){
		return areaOfSquare.calculateArea();
	}
	
	@Override
	public String toString() {
		 return String.format("Square {s=%.2f} Perimeter = %.4f Area = %.2f \n", getLength(), perimeter(),getArea() );
	}
	
	
	

}
