
package shapes;

public class Rectangle extends Parallelogram {
	

	//Two-argument constructor
	public Rectangle(double width, double height) {
		super(width, height);
	
	}
	
	// Print
	@Override
	public String toString() {
		
		 return String.format("Rectangle {w=%.2f, h=%.2f} perimeter = %.4f\n", getWidth(), getHeigth(), perimeter());
	}

}
