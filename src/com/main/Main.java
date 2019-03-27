package com.main;

public class Main {
	public static void main(String[] args) throws CloneNotSupportedException {
		Student a = new Student();
		a.setName("student a");
		a.getCourse().setName("EN");
		a.getCourse().setLenght("10");
	
		Student b = (Student) a .clone();
		b.setName("student bc hyugbojh");
		b.getCourse().setName("IT");
		System.out.println(a);
		System.out.println(b);
		
		
		
	}
}
