package com.he.capillary;

public class GradStudent extends Student {

	public GradStudent(String name, int year, String advisor) {
		super(name, year, null);
		this.advisor = advisor;
	}

	private String advisor;

	public void addCourse(String name) {
		if (super.getCourseCount() != 3) {
			super.addCourse(name);
		}
	}

	public double getTution() {
		if (this.getCourseCount() == 1 || this.getCourseCount() == 0) {
			return 500.00d;
		} else {
			return this.getCourseCount() * 1234.50d * 2;
		}
	}

	public int getYear() {
		return super.getYear() + 4;
	}

	public String getAdvisor() {
		return this.advisor;
	}

	public boolean isburnOut() {
		if (getYear() >= 9) {
			return true;
		} else {
			return false;
		}
	}

}
