package student;

// Import Classes

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//import java.util.function.Consumer;
//import java.util.function.BiConsumer;
//import java.util.function.Function;
//import java.util.function.Predicate;
import java.util.Optional;


public class StudentProcess {
	
	private static Student[] students = {
			new Student("Jack", "Smith", 50.0, "IT"),
			new Student("Aaron", "Johnson", 76.0, "IT"),
			new Student("Maaria", "White", 35.8, "Business"),
			new Student("John", "White", 47.0, "Media"),
			new Student("Laney", "White", 62.0, "IT"),
			new Student("Jack", "Jones", 32.9, "Business"),
			new Student("Wesley", "Jones", 42.89, "Media")};

	public static void main(String[] args) {
		
		
		// Task 1
		List<Student> studentList = Arrays.asList(students);
		
		System.out.print("Task 1 \n");
		System.out.print("\n");
		System.out.print("Complete Student list: \n");
		studentList.forEach(student -> System.out.print(student.toString()));
		System.out.print("\n");
		
		
		//Task 2
		System.out.print("Task 2 \n");
		System.out.print("\n");
		System.out.print("Students who got 50.0-100.0 sorted by grade: \n");
		studentList.stream().filter( student -> student.getGrade() >= 50.0 && student.getGrade() <= 100 )
		.sorted(Comparator.comparing(Student::getGrade)).
		forEach(student -> System.out.print(student.toString()));
		System.out.print("\n");

		
		//Task 3
		System.out.print("Task 3 \n");
		System.out.print("\n");
		System.out.print("First Student who got 50.0-100.0: \n");
		Optional<Student> stud = studentList.stream().filter(student -> student.getGrade() >= 50 && student.getGrade() <= 100).findFirst();
		System.out.println(stud.get());
		System.out.print("\n");
		
		
		//Task 4
		System.out.print("Task 4 \n");
		System.out.print("\n");
		System.out.print("Students in ascending order by last name then first: \n");
		studentList.stream().sorted(Comparator.comparing(Student::getFirstName)).sorted(Comparator.comparing(Student::getLastName)).
		forEach(student -> System.out.print(student.toString()));
		System.out.print("\n");
		
		System.out.print("Students in descending order by last name then first: \n");
		studentList.stream().sorted(Comparator.comparing(Student::getFirstName).reversed()).sorted(Comparator.comparing(Student::getLastName).reversed()).
		forEach(student -> System.out.print(student.toString()));
		System.out.print("\n");
		
		// Task 5
		System.out.print("Task 5 \n");
		System.out.print("\n");
		System.out.print("Unique Student last names: \n");
		studentList.stream().sorted(Comparator.comparing(student -> student.getLastName())).map(student -> student.getLastName()).distinct().forEach(student -> System.out.print(student.toString() + "\n"));   
		System.out.print("\n");
		
	
		
		

		
				
		
		
		
	
	}


}
