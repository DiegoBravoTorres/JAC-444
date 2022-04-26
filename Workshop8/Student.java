package student;

public class Student {
	
	private String firstName;
	private String lastName;
	private double grade;
	private String department;
	
	
	// Constructor
	public Student(String firstName, String lastName, double grade, String department) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.department = department;
		
	}

	// Getters and setters
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

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	// Get Name function
	public String getName() {	
		return getFirstName() + getLastName();
	}
	
	@Override
	public String toString() {
		 return String.format("%s %s %.2f %s \n", getFirstName(), getLastName(),getGrade(),getDepartment() );
	}
	
	
	

}
