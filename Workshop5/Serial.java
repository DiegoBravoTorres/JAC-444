package student;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileReader;
import java.io.IOException;

public class Serial extends Student {
		


	public static void main(String[] args) throws IOException{
		
		 // Define local variables
		 int stdIDI;
		 String firstNameI;
		 String lastNameI;
		 String[] coursesI;
		 
		 // Temporary array of students use to store all the information entered by the user
		 ArrayList<Student> studentList = new ArrayList<Student>();
		 
		 // Define a Buffered Reader read the information from the keyboard
		 BufferedReader inputStream = null;
		 inputStream = new BufferedReader(new InputStreamReader(System.in));
		 
		 // Keep entering data until the user types N
		 boolean keepEntering = true;
		 while(keepEntering) {
			 
			    Student student = new Student();
			 
			    // Set ID
				System.out.print("Please enter the student ID: ");
				stdIDI = Integer.parseInt(inputStream.readLine());
				student.setStdID(stdIDI);
				
				// Set First Name
				System.out.print("Please enter the student first name: ");
				firstNameI = inputStream.readLine();
				student.setFirstName(firstNameI);
				
				// Set Last Name
				System.out.print("Please enter the student last name: ");
				lastNameI = inputStream.readLine();
				student.setLastName(lastNameI);
				
				// Get Student Courses
				System.out.print("Enter the courses for this specific student, separated by a semicolon ';': ");
				coursesI = inputStream.readLine().split(";");
				ArrayList<String> coursesList = new ArrayList<>(Arrays.asList(coursesI));
				student.setCourses(coursesList);
				
				// Add student to list of students
				studentList.add(student);
				
				System.out.print("Do you need to add another student? (Y/N)");
				String addMore = inputStream.readLine();
				
				if(addMore.equals("N") || addMore.equals("n")) {
					keepEntering = false;
				}
			 
		 }
		
		// Open Streams
		FileOutputStream outStream = new FileOutputStream("students.obj");
		ObjectOutputStream objectSteam = new ObjectOutputStream(outStream);
		
		// Save student list object into the file
		objectSteam.writeObject(studentList);
		
		// Close Streams
		objectSteam.close();
		outStream.close();
		
		// Print final message
		System.out.print("Students Sucesfully Saved");
			
	
		

	}

}
