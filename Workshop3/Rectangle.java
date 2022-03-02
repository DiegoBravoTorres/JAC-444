
package shapes;

public class Rectangle implements Shape {
	
	private double width;
	private double heigth;

	//Two-argument constructor
	public Rectangle(double width, double height) {
		this.width = width;
		this.heigth = height;
	}
	
	//Getters 
	public double getWidth() {
		return this.width;
	}
	
	public double getHeigth() {
		return this.heigth;
	}
	
	// Override functions for this specific type of shape
	@Override
	public double perimeter() {
		return (getWidth() * 2) + (getHeigth() * 2);
	}
	
	@Override
	public String toString() {
		
		 return String.format("Rectangle {w=%.2f, h=%.2f} perimeter = %.4f\n", getWidth(), getHeigth(), perimeter());
	}

}
