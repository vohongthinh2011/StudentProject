package com.region20.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.region20.dao.StudentDao;
import com.region20.model.Student;
import com.region20.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	@Transactional
	public void add(Student student) {
		studentDao.add(student);

	}

	@Transactional
	public void edit(Student student) {
		studentDao.edit(student);
	}

	@Transactional
	public void delete(int id) {
		studentDao.delete(id);
	}

	@Transactional
	public Student getStudent(int id) {
		return studentDao.getStudent(id);
	}

	@Transactional
	public List getAllStudent() {
		return studentDao.getAllStudent();
	}




}
