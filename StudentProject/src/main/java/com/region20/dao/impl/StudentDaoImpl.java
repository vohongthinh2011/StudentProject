package com.region20.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.region20.dao.StudentDao;
import com.region20.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory session;
	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(student);

	}

	@Override
	public void edit(Student student) {
		session.getCurrentSession().update(student);

	}

	@Override
	public void delete(int id) {
		session.getCurrentSession().delete(getStudent(id));

	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return (Student)session.getCurrentSession().get(Student.class, id);
	}

	@Override
	public List getAllStudent() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Student").list();
	}

}
