package com.saswat23.springjdbc.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.saswat23.springjdbc.model.Student;

@Repository
public class StudentRepoImpl implements StudentRepo {

	private String sql;
	
	private JdbcTemplate jdbc;
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

//	public void add(Student student) {
//		jdbc.update("insert into student (rollno, name, marks) values (?,?,?)", 
//				student.getrollno(), student.getName(), student.getMarks());
////		System.out.println(jdbc);
//		System.out.println("Student added by repo: "+student);
//	}
//	
//	public List<Student> findAll() {
//		sql = "select * from student";
//		
//		RowMapper<Student> row = new SimplePropertyRowMapper<Student>(Student.class);
//		List<Student> students = jdbc.query(sql, row);
//		return students;
//	}

	@Override
	public int saveStudent(Student student) {
		sql = "insert into student (rollno, name, marks, user_id) values (?,?,?,?)";
		Object[] sqlParams = {student.getRollNo(), student.getName(), student.getMarks(), student.getUserId()};
		System.out.println("SqlParams: "+sqlParams);
		int rowsInserted = jdbc.update(sql, sqlParams);
		
		return rowsInserted;
	}

	@Override
	public Student findStudentById(String studentId) {
		sql = "select rollno, name, marks, user_id as userId from student where user_id = ?";
		Student student = jdbc.queryForObject(sql, new Object[]{studentId}, new int[] {1}, new BeanPropertyRowMapper<>(Student.class));
		return student;
	}

	@Override
	public List<Student> findAllStudents() {
		sql = "select rollno, name, marks, user_id as userId from student";
		List<Student> students = jdbc.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
		return students;
	}

	@Override
	public int deleteStudent(Student student) {
		sql = "delete from student where user_id = ?";
		int rowsDeleted = jdbc.update(sql, student.getUserId());
		return rowsDeleted;
	}

	@Override
	public Student updateStudentData(Student student) {
		sql = "update student set rollno = ?, name=?, marks=? where user_id = ?";
		Object[] sqlParams = {student.getRollNo(), student.getName(), student.getMarks(), "stud001"};
		int rowsUpdated = jdbc.update(sql, sqlParams);
		System.out.println(rowsUpdated+" records updated.");
		return findStudentById(student.getUserId());
	}

	@Override
	public int batchInsertStudents(List<Student> students) {
		// TODO Auto-generated method stub
		
		List<Object[]> sqlParamsList = new ArrayList<Object[]>();
		
		students.forEach(student -> {
			Object[] sqlParams = {
					student.getRollNo(),
					student.getName(),
					student.getMarks(),
					student.getUserId()
			};
			sqlParamsList.add(sqlParams);
		});
		
		sql = "insert into student (rollno, name, marks, user_id) values (?,?,?,?)";
		int rowsInserted = Arrays.stream(jdbc.batchUpdate(sql, sqlParamsList))
				.sum();
		
		return rowsInserted;
	}

	@Override
	public void truncateStudentData() {
		sql = "truncate table student";
		jdbc.execute(sql);
		System.out.println("Student table truncated..");
	}

}
