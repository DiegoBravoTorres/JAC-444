package student;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class Deserial extends Student {
	

	public static void main(String args[]) throws IOException {
		
		// Create temporary array of students
		ArrayList<Student> students = new ArrayList<Student>();

		try {

			//Create file input stream object using the "students.obj" as parameter
			FileInputStream fis = new FileInputStream("students.obj");

			//Create an Object Input Stream using the file input as parameter
			ObjectInputStream ois = new ObjectInputStream(fis);

			// Read objects from the file and store them into our temporary array
			students = (ArrayList<Student>)ois.readObject();
			
			// Close both stream objects
			ois.close();
			fis.close();

		} catch (Throwable e) {
			System.err.println(e);
		}
		
		// Keep the count of students printed
		int studNum =0;
		
		// Loop through every student and print their information
		for (Student student : students) {
			System.out.println("Student Number of Student No " + ++studNum  +": " + student.getStdID());
			System.out.println("First Name of Student No " + studNum  +": " + student.getFirstName());
			System.out.println("Last Name of Student No " + studNum  +": " + student.getLastName());
			System.out.println("Student No " + studNum  +" is enrolled in "+ student.getCourses().size() + " courses: ");
			
			// Loop through every course of each student and print it
			for (String course : student.getCourses()) {
				System.out.println(" " + course);
			}
			
			
		}
		
		

	}

}
