package com.region20.dao;

import java.util.List;

import com.region20.model.Student;

public interface StudentDao {
	public void add(Student student);
	public void edit(Student student);
	public void delete(int id);
	public Student getStudent(int id);
	public List getAllStudent();
}
