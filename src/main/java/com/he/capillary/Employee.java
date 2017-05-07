package com.he.capillary;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class Name {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Address {
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

public class Employee {

	private int number;
	private Name name1 = new Name();
	private Address address1 = new Address();
	private Date hireDate = new Date();
	String number1;

	public void getDate1(int d, int m, int y) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(y, m, d);
		hireDate = calendar.getTime();
	}

	public void getID(int x) {
		number = x;

	}

	public void setName(String n) {
		name1.setName(n);
	}

	public void getAddress(String a) {
		address1.setAddress(a);
	}

	String z;

	public String toString() {

		number1 = String.valueOf(number);
		String name2 = name1.getName();
		String address2 = address1.getAddress();
		String hireDate2 = String.valueOf(hireDate);

		z = number1 + " " + name2 + " " + address2 + " " + hireDate2;
		return z;
	}

	public static void main(String args[]) {
		
		String path ="";
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter amount of Employees: ");
		int input1 = input.nextInt();
		input.nextLine();

		Employee[] employees = new Employee[input1];
		for (int i = 0; i < input1; i++) {

			System.out.println("Please enter the employee ID: ");
			int employeeID = input.nextInt();
			input.nextLine();
			employees[i] = new Employee();
			employees[i].getID(employeeID);

			System.out.println("Please enter the employees Name: ");
			String name2 = input.nextLine();
			employees[i].setName(name2);

			System.out.println("Please enter the employee's address: ");
			String address2 = input.nextLine();
			employees[i].getAddress(address2);

			System.out.println("please enter hire date, day (1-31),");
			System.out.print("month (1-12), year (1901 - 2019) in order on seperate");
			System.out.print(" lines: ");
			int input2 = input.nextInt();
			int input3 = input.nextInt();
			int input4 = input.nextInt();

			employees[i].getDate1(input2, input3, input4);

			System.out.println(employees[i]);

		}

	}
}
