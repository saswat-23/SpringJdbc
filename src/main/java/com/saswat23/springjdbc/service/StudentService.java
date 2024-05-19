package com.saswat23.springjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saswat23.springjdbc.model.Student;
import com.saswat23.springjdbc.repository.StudentRepo;

@Service
public class StudentService {

	private StudentRepo repo;
	
	public StudentRepo getRepo() {
		return repo;
	}
	
	@Autowired
	public void setRepo(StudentRepo repo) {
		this.repo = repo;
	}

	//In the service layer, the student bean is further passed to the Repo layer to save it in the DB.
	public void addStudent(Student student) {
		repo.add(student);
	}

	//This method is used to fetch all the Student records through the Repo Layer.
	public List<Student> showAllStudents() {
		return repo.findAll();
	}

}
