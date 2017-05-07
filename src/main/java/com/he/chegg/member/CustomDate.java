package com.he.chegg.member;

public class CustomDate {

	private int month;
	private int day;
	private int year;

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public CustomDate(int month, int day, int year) {
		super();
		this.month = month;
		this.day = day;
		this.year = year;
	}

	@Override
	public String toString() {
		return "CustomDate [month=" + month + ", day=" + day + ", year=" + year + "]";
	}

}
