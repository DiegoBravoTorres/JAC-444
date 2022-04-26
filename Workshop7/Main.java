package shapes;
import java.io.*;


public class Main {

	public static void main(String[] args) {
		
		
		// Define main method variables		
		final String FILENAME = "shapes.txt";
		String item ;
		boolean isValid = false;
		int numOfShapes = 0;
		
		// Data structure that will store all shapes
		Shape[] shapes = new Shape[32];
		
		
		
		System.out.println("------->JAC 444 Assignment 3<-------");
		System.out.println("------->Task1 ... <-------");
		
		
		// Read items from file
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			
			while ((item = br.readLine()) != null) {	
				
				String[] tokens = item.split(",");
				
				
				// Check conditions for Circle
				if (tokens[0].equals("Circle")) {
					
					//Check for the radius to be positive
					if(Double.parseDouble(tokens[1]) <0 ) {
						System.out.println("Invalid radius!");
						isValid= false;
					}else {
						isValid= true;	
					}
					
					//Check for the right number of dimensions
					if ( tokens.length != 2) 
						isValid = false;
					
					
				}
				
				// Check conditions for Square
				if (tokens[0].equals("Square")) {
					
					// //Check for the sides to be positive
					if(Double.parseDouble(tokens[1]) < 0 ) {
						System.out.println("Invalid side!");
						isValid= false;
					}else {
						isValid= true;	
					}
					
					//Check for the right number of dimensions
					if ( tokens.length != 2) 
						isValid = false;
					
				}
				
				// Check conditions for Rectangle
				if (tokens[0].equals("Rectangle")) {
					
					if(Double.parseDouble(tokens[1]) < 0 ) {
						System.out.println("Invalid side(s)!");
						isValid= false;
					}else {
						isValid= true;	
					}
					
					if ( tokens.length != 3) 
						isValid = false;
					
				}
				
				// Check conditions for Parallelogram
				if (tokens[0].equals("Parallelogram")) {
					
					if(Double.parseDouble(tokens[1]) < 0 ) {
						System.out.println("Invalid side(s)!");
						isValid= false;
					}else {
						isValid= true;	
					}
					
					if ( tokens.length != 3) 
						isValid = false;
					
				}
				
				// Check conditions for Triangle
				if (tokens[0].equals("Triangle")) {
					
					// Check that the second token is greater than 0 and that the number of tokens is 4
					if(Double.parseDouble(tokens[1]) < 0  || 
							// Check that no side is larger than the other two
							Double.parseDouble(tokens[1]) > (Double.parseDouble(tokens[2]) + Double.parseDouble(tokens[3])) || 
							Double.parseDouble(tokens[2]) > (Double.parseDouble(tokens[3]) + Double.parseDouble(tokens[1])) ||
							Double.parseDouble(tokens[3]) > (Double.parseDouble(tokens[1]) + Double.parseDouble(tokens[2])))
					{
						System.out.println("Invalid side(s)!");
						isValid= false;
					}else {
						isValid= true;	
					}
					
					if ( tokens.length != 4) 
						isValid = false;
					
				}
				
			
				
				if(!(tokens[0].equals("Circle") || tokens[0].equals("Square") || tokens[0].equals("Rectangle") || tokens[0].equals("Parallelogram") || tokens[0].equals("Triangle"))) {
					
					isValid=false;
				}
				
				
				// If all the criteria is meet, create and store shapes accordingly
				if(isValid) {
					
					if(tokens[0].equals("Rectangle")) {
						shapes[numOfShapes] =  new Rectangle(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]));
					}
					if(tokens[0].equals("Circle")) {
						shapes[numOfShapes] =  new Circle(Double.parseDouble(tokens[1]));
					}
					if(tokens[0].equals("Triangle")) {
						shapes[numOfShapes] =  new Triangle(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));
					}
					if(tokens[0].equals("Parallelogram")) {
						shapes[numOfShapes] =  new Parallelogram(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]));
					}
					if(tokens[0].equals("Square")) {
						shapes[numOfShapes] =  new Square(Double.parseDouble(tokens[1]));
					}
					
					numOfShapes++;
					
				}
				
	
			}
			
			
				} catch (IOException e) {
				System.out.println(e.getMessage());
				}
		
		
		
		System.out.println("\n" + numOfShapes + " shapes were created:");
		
		// Print all the details for all the stored shapes
		for (Shape shape : shapes) {
			if(shape != null)
			System.out.println(shape);
		}
		
		
		
		
		// Task 2
		System.out.println("------->Task2 ... <-------");
		
		
		// Define first mins and maxs
		double minPerimeterTriangle = 1000.00;
		double maxPerimeterCircle = 0.00;
		
		for (Shape shape : shapes) {
			
			// Find Minimum Perimeter along Circles
			if(shape.getClass().getSimpleName().equals("Triangle"))
				if(shape.perimeter() < minPerimeterTriangle) {
					minPerimeterTriangle = shape.perimeter();
				}
			
			// Find Maximum Perimeter along Circles
			if(shape.getClass().getSimpleName().equals("Circle"))
				if(shape.perimeter() > maxPerimeterCircle) {
					maxPerimeterCircle = shape.perimeter();
				}
		}
		
		// New Array and Count
		Shape[] newShapes = new Shape[32];
		int newCount =0;
		
		// Copy all the previous stored shapes except for Triangles with minimum perimeter and Circles with maximum perimeter
		for (Shape shape : shapes) {
					
			// Print everything but Triangles and Circles
			if(shape != null && !(shape.getClass().getSimpleName().equals("Circle")) && !(shape.getClass().getSimpleName().equals("Triangle")))
				newShapes[newCount++] = shape;
		
			
			// Print all the Triangles but the smaller ones
			if(shape.getClass().getSimpleName().equals("Triangle") && shape.perimeter() > minPerimeterTriangle )
				newShapes[newCount++] = shape;
					
			// Print all the Circles but the bigger ones 
			if(shape.getClass().getSimpleName().equals("Circle") && shape.perimeter() < maxPerimeterCircle )
				newShapes[newCount++] = shape;
			
				}
		
		// Print all the details for all the stored shapes
				for (Shape shape : newShapes) {
					if(shape != null)
					System.out.println(shape);
				}
		
		// Task 3
		System.out.println("------->Task3 ... <-------");
		
		// Define variables
		double perimeterParallelogram = 0.0;
		double perimeterTriangles = 0.0;
		
		for (Shape shape : newShapes) {
			
			if(shape != null) {
				
				// Keep adding the perimeter of all Parallelograms
				if(shape.getClass().getSimpleName().equals("Parallelogram"))
					perimeterParallelogram += shape.perimeter();
				
				// Keep adding the perimeter of all Triangles but the smaller ones
				if(shape.getClass().getSimpleName().equals("Triangle"))
					perimeterTriangles += shape.perimeter();
				
			}
			
			
		}
		
		
		//Print totals
		System.out.println("Total perimeter of Parallelogram is: " + perimeterParallelogram);
		System.out.println("Total perimeter of Triangle is: " + perimeterTriangles);
		
		// Task 4
		System.out.println(" ");
		System.out.println("------->Task4 ... <-------");
		
		// Print all the details for all the stored shapes
				for (Shape shape : shapes) {
					if(shape != null)
					System.out.println(shape);
				}
			
		
		
	}
	

}
