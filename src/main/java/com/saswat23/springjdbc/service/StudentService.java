package com.saswat23.springjdbc.service;

import org.springframework.stereotype.Service;

import com.saswat23.springjdbc.model.Student;

@Service
public class StudentService {

	public void addStudent(Student student) {
		System.out.println("Added student: "+student);
	}

}
