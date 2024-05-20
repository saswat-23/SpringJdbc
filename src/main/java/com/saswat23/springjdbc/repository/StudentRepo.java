package com.saswat23.springjdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.SimplePropertyRowMapper;
import org.springframework.jdbc.core.SqlRowSetResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.saswat23.springjdbc.model.Student;

@Repository
public class StudentRepo {

	private JdbcTemplate jdbc;
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void add(Student student) {
		jdbc.update("insert into student (rollNo, name, marks) values (?,?,?)", 
				student.getRollNo(), student.getName(), student.getMarks());
//		System.out.println(jdbc);
		System.out.println("Student added by repo: "+student);
	}
	
	public List<Student> findAll() {
		String sql = "select * from student";
		
		RowMapper<Student> row = new SimplePropertyRowMapper<Student>(Student.class);
		List<Student> students = jdbc.query(sql, row);
		return students;
	}

}
