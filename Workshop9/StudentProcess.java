package student;

// Import Classes

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
		
		// Task 6
		System.out.print("Task 6 \n");
		System.out.print("\n");
		System.out.print("Student names in order by last name then first name: \n");
		Stream<Student> studentListStream = studentList.stream();
		studentListStream.sorted(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName)).map(student -> student.getName()).forEach(System.out::println);
		System.out.print("\n");
		
		// Task 7
		System.out.print("Task 7 \n");
		System.out.print("\n");
		System.out.print("Count of Students by department: \n");
		Map<String, List<Student>> mapedStudents = studentList.stream().collect(Collectors.groupingBy(student -> student.getDepartment()));
		
		mapedStudents.forEach((dep, students) -> {
			System.out.print(dep.toString() + "\n");
			students.forEach(student -> System.out.print(" " + student.toString()));
		});
		System.out.print("\n");
		
		// Task 8
		System.out.print("Task 8 \n");
		System.out.print("\n");
		System.out.print("Students by department: \n");
		
		Map<String, Long> mapedStudentsSize = mapedStudents.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, value -> Long.valueOf(value.getValue().size())));
		
		mapedStudentsSize.forEach((dep, num) -> {
			System.out.print(dep.toString() + " has " + num + " student(s) \n");
			
		});
		
		// Task 9
		System.out.print("\nTask 9 \n");
		System.out.print("\n");
		System.out.print("Sum of Students' grades: ");
		System.out.print(studentList.stream().mapToDouble(student -> student.getGrade()).summaryStatistics().getSum());
		System.out.print("\n");
		
		// Task 10
		System.out.print("\nTask 10 \n");
		System.out.print("\n");
		System.out.println("Sum of Students' grades: " + String.format("%.2f",studentList.stream().mapToDouble(student -> student.getGrade()).summaryStatistics().getAverage()));
		
		
		
		
		
		
		

		
				
		
		
		
	
	}


}
