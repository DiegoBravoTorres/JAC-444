
package student;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	//Class fields
	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses = new ArrayList<String> () ;
	
	
	//Full arguments constructor
	public Student(int stdID, String firstName, String lastName, ArrayList<String> courses) {
		
		this.stdID = stdID;
		this.firstName =  firstName;
		this.lastName = lastName;
		this.courses = courses;
			
	}
	
	public Student() {}
	

	
    //Getters and setters
	public int getStdID() {
		return stdID;
	}


	public void setStdID(int stdID) {
		this.stdID = stdID;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public ArrayList<String> getCourses() {
		return courses;
	}


	public void setCourses(ArrayList<String> courses) {
		
		
		for (String course : courses) {
			this.courses.add(course);
		}
		
	}
	
	

}
