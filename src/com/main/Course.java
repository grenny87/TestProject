package com.main;

public class Course implements Cloneable  {
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}



	private String name;
	
	@Override
	public String toString() {
		return "Course [name=" + name + ", lenght=" + lenght + "]";
	}



	private String lenght;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLenght() {
		return lenght;
	}

	public void setLenght(String lenght) {
		this.lenght = lenght;
	}
	
	
	
}
