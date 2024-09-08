package com.saswat23.springjdbc.repository.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.saswat23.springjdbc.model.Student;

public class StudentResultSetExtractor implements ResultSetExtractor<Map<String,List<Student>>> {

	@Override
	public Map<String,List<Student>> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Map<String,List<Student>> studentMap = new HashMap<>();
		List<Student> studList;
		while(rs.next()) {
			Student s = new Student (rs.getInt("rollNo"), rs.getString("name"), rs.getFloat("marks"), 
					rs.getString("user_id"), rs.getString("address"));
			studList = studentMap.get(s.getAddress());
			if(studList==null) {
				studList = new ArrayList<Student>();
			}
			studList.add(s);
			studentMap.put(s.getAddress(), studList);
		}
		
		return studentMap;
	}

}
