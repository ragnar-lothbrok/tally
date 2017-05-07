package com.he.capillary;

import java.util.HashSet;
import java.util.Set;

public class Student {

	private String name;
	private int year;
	private Set<String> courses;

	public Student(String name, int year, Set<String> courses) {
		super();
		this.name = name;
		this.year = year;
		this.courses = courses;
	}

	public void addCourse(String name) {
		if(this.courses == null){
			courses = new HashSet<String>();
		}
		this.courses.add(name);
	}

	public void dropAll() {
		this.courses.clear();
	}

	public int getCourseCount() {
		return this.courses.size();
	}

	public String getName() {
		return this.name;
	}

	public double getTution() {
		return this.courses.size() * 1234.50d;
	}

	public int getYear() {
		return this.year;
	}

}
