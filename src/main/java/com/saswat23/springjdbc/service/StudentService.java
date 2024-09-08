package com.saswat23.springjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saswat23.springjdbc.model.Student;
import com.saswat23.springjdbc.repository.StudentRepoImpl;

@Service
public class StudentService {

	private StudentRepoImpl repo;
	
	public StudentRepoImpl getRepo() {
		return repo;
	}
	
	@Autowired
	public void setRepo(StudentRepoImpl repo) {
		this.repo = repo;
	}

	//In the service layer, the student bean is further passed to the Repo layer to save it in the DB.
	public void addStudent(Student student) {
		repo.saveStudent(student);
	}

	//This method is used to fetch all the Student records through the Repo Layer.
	public List<Student> showAllStudents() {
		return repo.findAllStudents();
	}

}
