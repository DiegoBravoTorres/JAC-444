
package shapes;

public class Rectangle extends Parallelogram {
	
	
	// Lambda function to get area
	private GetArea areaOfRectangle = () -> this.getHeigth() * getWidth();
	

	//Two-argument constructor
	public Rectangle(double width, double height) {
		super(width, height);
	
	}
	
	//Getter function to pass area using lambda 
	public double getArea() {
		return areaOfRectangle.calculateArea();
	}
	
	// Print
	@Override
	public String toString() {
		 return String.format("Rectangle {w=%.2f, h=%.2f} Perimeter = %.4f Area = %.2f\n", getWidth(), getHeigth(), perimeter(), getArea());
	}

}
