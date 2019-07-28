package com.region20.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO) // for autonumber
	private int id;
	@Column
	private String schoolYear;
	@Column
	private String campus;
	@Column
	private String studentId;
	@Column
	private String entryDate;
	@Column
	private String gradeLevel;
	@Column
	private String name;

	public Student() {

	}
	public Student(int id, String schoolYear, String campus, String studentId, String entryDate, String gradeLevel,
			String name) {
		super();
		this.id = id;
		this.schoolYear = schoolYear;
		this.campus = campus;
		this.studentId = studentId;
		this.entryDate = entryDate;
		this.gradeLevel = gradeLevel;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String getGradeLevel() {
		return gradeLevel;
	}
	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
