package com.he.capillary;

import java.util.ArrayList;
import java.util.List;

class Person {
	private String firstName;
	
	//Might be more fields

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Person(String firstName) {
		super();
		this.firstName = firstName;
	}

}

public class SO1 {

	public static void main(String[] args) {

		List<Person> personList = new ArrayList<Person>();

		for (int i = 0; i < 10; i++) {
			personList.add(new Person("Name "+i));
		}
		
		
		List<String> adaptorList = new ArrayList<String>();
		personList.forEach( p -> adaptorList.add(p.getFirstName()));
		
		System.out.println(adaptorList);
	}

}
