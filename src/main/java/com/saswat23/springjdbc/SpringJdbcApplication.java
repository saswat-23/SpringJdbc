package com.saswat23.springjdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.saswat23.springjdbc.model.Student;
import com.saswat23.springjdbc.service.StudentService;

@SpringBootApplication
public class SpringJdbcApplication {

	static ApplicationContext context;
	
	public static void main(String[] args) {
		context = SpringApplication.run(SpringJdbcApplication.class, args);
		
		StudentService studentService = context.getBean(StudentService.class);
		
		
		// Bean of Student is fetched from the context
		Student student = context.getBean(Student.class);
		student.setRollNo(21);
		student.setName("SaswatMonty");
		student.setMarks(84.23f);
		student.setUserId("stud202400x");

		
		// Clear existing ercords from the database
		studentService.clearStudentData();
		System.out.println("All previous student data cleared from DB.");
		
		// Student bean is passed to the Service layer to save it in the DB
		studentService.addStudent(student);
		
		// Add list of student records to the DB
		int addCount = studentService.addStudentList(getTempStudentList());
		System.out.println(addCount+" student data added successfully!");
		
		// Show all the student records present in the DB
		List<Student> students = studentService.showAllStudents();
		System.out.println("The student list is: ");
		students.forEach(System.out::println);
		System.out.println("\n\n ");
		
		// Student record is updated and saved in the DB
		student.setMarks(35.66f);
		student.setName("Saswat Mohan");
		student.setRollNo(99);
		student = studentService.updateStudentInfo(student);
		System.out.println("Student data updated for userid: "+student.getMarks());
		System.out.println("Updated Student Data: "+student);
		
		// Find a student from the DB by using its userId
		Student stud2024_xxx = studentService.findStudentById("stud2024_003");
		System.out.println("stud2024_003 details: "+stud2024_xxx);
		
		// Delete the required student from the DB
		int deleteCount = studentService.deleteStudent(stud2024_xxx);
		System.out.println(deleteCount+" student(s) deleted successfully!");
		System.out.println("Deleted student info: "+stud2024_xxx);
		
		System.out.println("\n\nThanks for using Student Services...");
		
	}

	
	public static List<Student> getTempStudentList() {
		
		Student student1 = new Student(001, "Sanu", (float) (100*Math.random()), "stud2024_001");
		Student student2 = new Student(012, "Lovely", (float) (100*Math.random()), "stud2024_002");
		Student student3 = new Student(023, "Sari", (float) (100*Math.random()), "stud2024_003");
		Student student4 = new Student(104, "Dadu", (float) (100*Math.random()), "stud2024_004");
		Student student5 = new Student(205, "Gudu", (float) (100*Math.random()), "stud2024_005");
		
		List<Student> studentList = new ArrayList<>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);
		studentList.add(student5);
		
		System.out.println("Temp student list is: ");
		studentList.forEach(System.out::println);
		System.out.println("\n\n ");
		
		return studentList;
	}
	
}
