package com.saswat23.springjdbc.repository;

import org.springframework.stereotype.Repository;

import com.saswat23.springjdbc.model.Student;

@Repository
public class StudentRepo {

	public void add(Student student) {
		System.out.println("Student added by repo: "+student);
	}

}
