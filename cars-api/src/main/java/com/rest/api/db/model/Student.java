package com.rest.api.db.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_tab")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "SECTION1")
	private String section;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY
			//, mappedBy="student"
			)
	@JoinTable(name = "stu_Cou_tab", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = {
	@JoinColumn(name = "COURSE_ID") })
	private List<Course> course;

	public Student() {

	}

	public long getId() {
		return id;
	}

	public Student(String firstName, String lastName, String section, List<Course> course) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.section = section;
		this.course = course;
	}

	public Student(String firstName, String lastName, String section) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.section = section;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", section=" + section
				+"]";
	}

}