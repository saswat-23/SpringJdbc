package com.saswat23.springjdbc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.saswat23.springjdbc.model.Student;

@Repository
public interface StudentRepo {

	int saveStudent(Student student);
	Student findStudentById(String studentId);
	List<Student> findAllStudents();
	int deleteStudent(Student student);
	Student updateStudentData(Student student);
	int batchInsertStudents(List<Student> students);
	void truncateStudentData();
	
}
