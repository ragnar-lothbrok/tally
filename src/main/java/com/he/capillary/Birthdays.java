package com.he.capillary;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Birthdays {

	private static SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

	public static void main(String[] args) {
		int days_of_bday1;
		int days_of_bday2;
		int day;
		int year = LocalDate.now().getYear();
		Scanner console = new Scanner(System.in);

		System.out.print("Please enter todays's date (month day) : ");
		int present_month = console.nextInt();
		int today_date = console.nextInt();

		Calendar firstDate = Calendar.getInstance();
		firstDate.set(year, present_month-1, today_date);
		System.out.println("today is # " + format.format(firstDate.getTimeInMillis()) + ",day #"
				+ firstDate.get(Calendar.DAY_OF_YEAR) + " of the year.");

		// ---------------------------------------------------------------------------------------------------
		System.out.print("Please enter person #1's (month day) : ");
		int person1_bday_month = console.nextInt();
		int person1_bday_date = console.nextInt();

		Calendar birthDate = Calendar.getInstance();
		birthDate.set(year, person1_bday_month-1, person1_bday_date);
		System.out.println(format.format(birthDate.getTimeInMillis()) + " falls on day #"
				+ birthDate.get(Calendar.DAY_OF_YEAR) + " of " + getTotalDays(year));
		int days = 0;
		if(birthDate.compareTo(firstDate) > 0){
			days = Math.abs(firstDate.get(Calendar.DAY_OF_YEAR) - birthDate.get(Calendar.DAY_OF_YEAR));
			System.out.println("Your next birthday is in "+days +" day(s).");
		}else {
			days = getTotalDays(year) - firstDate.get(Calendar.DAY_OF_YEAR) + birthDate.get(Calendar.DAY_OF_YEAR);
			System.out.println("Your next birthday is in "+days+" day(s).");
		}
		
		firstDate.set(Calendar.YEAR, year+1);
		// ---------------------------------------------------------------------------------------------------
		
		
		System.out.print("Please enter person #2’s birthday (month day):");
		int present_month1 = console.nextInt();
		int today_date1 = console.nextInt();
		Calendar secondDate = Calendar.getInstance();
		secondDate.set(year, present_month1-1, today_date1);
		System.out.println("today is # " + format.format(secondDate.getTimeInMillis()) + ",day #"
				+ secondDate.get(Calendar.DAY_OF_YEAR) + " of the year.");

		// ---------------------------------------------------------------------------------------------------
		System.out.print("Please enter person #2's (month day) : ");
		int person2_bday_month = console.nextInt();
		int person2_bday_date = console.nextInt();

		Calendar birthDate2 = Calendar.getInstance();
		birthDate2.set(year, person2_bday_month-1, person2_bday_date);
		System.out.println(format.format(birthDate2.getTimeInMillis()) + " falls on day #"
				+ birthDate2.get(Calendar.DAY_OF_YEAR) + " of " + getTotalDays(year));
		
		int days1 = 0;
		if(birthDate2.compareTo(secondDate) > 0){
			days1 = Math.abs(secondDate.get(Calendar.DAY_OF_YEAR) - birthDate2.get(Calendar.DAY_OF_YEAR));
			System.out.println("Your next birthday is in "+days1 +" day(s).");
		}else {
			days1 = getTotalDays(year) - secondDate.get(Calendar.DAY_OF_YEAR) + birthDate2.get(Calendar.DAY_OF_YEAR);
			System.out.println("Your next birthday is in "+days1 +" day(s).");
		}

		// ---------------------------------------------------------------------------------------------------
		if(days < days1){
			System.out.println("Person #1’s birthday is sooner.");
		}else if(days > days1){
			System.out.println("Person #2’s birthday is sooner.");
		}else{
			System.out.println("Same Days. :)");
		}

	}
	
	private static int compareDates(Date date1,Date date2){
		int result = date1.compareTo(date2);
		if(result == 0){
			return 0;
		}else{
			return result;
		}
	}

	private static int getTotalDays(int year) {
		if (year % 100 == 0) {
			if (year / 400 == 0) {
				return 366;
			} else {
				return 365;
			}
		} else {
			if (year % 4 == 0) {
				return 366;
			} else {
				return 365;
			}
		}
	}
}
