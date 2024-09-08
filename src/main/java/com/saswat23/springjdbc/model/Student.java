package com.saswat23.springjdbc.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
	
	private int rollNo;
	private String name;
	private float marks;
	private String userId;
	
	public Student() {};
	
	public Student(int rollNo, String name, float marks, String userId) {
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
		this.userId = userId;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + ", userId=" + userId + "]";
	}
	

}
