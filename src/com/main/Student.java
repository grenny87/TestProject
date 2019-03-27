package com.main;

public class Student implements Cloneable  {
	@Override
	public String toString() {
		return "Student [name=" + name + ", course=" + course + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student student = (Student) super.clone();
		
		Course course = (Course) student.getCourse().clone();
		student.setCourse(course);
		return student;
	}
	private String name;
	private Course course;
	
	public Student() {
		this.course = new Course();
	}
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
