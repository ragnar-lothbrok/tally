package p1caccia;

import javax.swing.JOptionPane;

public class StudentListing {
	private String name;
	private String idNumber;
	private String gpa;

	public StudentListing(String n, String i, String g) {
		name = n;
		idNumber = i;
		gpa = g;
	}

	public StudentListing() {
		this.name = "";
		this.idNumber = "";
		this.gpa = "";
	}

	public String toString() {
		return ("Student name is " + name + "\nID Number is " + idNumber + "\nGPA is " + gpa + "\n");
	}

	public StudentListing deepCopy() {
		StudentListing clone = new StudentListing(name, idNumber, gpa);
		return clone;
	}

	public int compareTo(String targetKey) {
		return (name.compareTo(targetKey));
	}

	public void input() {
		name = JOptionPane.showInputDialog("Enter a Name: ");
		idNumber = JOptionPane.showInputDialog("Enter the ID Number: ");
		gpa = JOptionPane.showInputDialog("Enter the GPA: ");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

}
