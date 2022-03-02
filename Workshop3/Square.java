
package shapes;

public class Square implements Shape {
	
	private double length;
	
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
	
	@Override
	public String toString() {
		
		 return String.format("Square {s=%.2f} perimeter = %.4f\n", getLength(), perimeter());
	}

}
