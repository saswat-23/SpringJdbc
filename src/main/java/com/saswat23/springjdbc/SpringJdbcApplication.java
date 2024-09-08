package com.saswat23.springjdbc;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.saswat23.springjdbc.model.Student;
import com.saswat23.springjdbc.service.StudentService;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		
		// Bean of Student is fetched from the context
		Student student = context.getBean(Student.class);
		student.setRollNo(21);
		student.setName("SaswatMonty");
		student.setMarks(84.23f);
		student.setUserId("stud2024001");

		// Student bean is passed to the Service layer to save it in the DB
		StudentService studentService = context.getBean(StudentService.class);
		studentService.addStudent(student);
		
		List<Student> students = studentService.showAllStudents();
		System.out.println("The student list is: "+students);
	}

}
