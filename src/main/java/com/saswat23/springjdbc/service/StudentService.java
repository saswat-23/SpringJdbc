package com.saswat23.springjdbc.service;

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

	//In the service layer, the student bean is futher passed to the Repo layer to save it in the DB.
	public void addStudent(Student student) {
		repo.add(student);
	}

}
