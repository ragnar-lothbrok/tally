package com.he.capillary;

import java.util.Scanner;

public class Interests {

	private float rate;
	private double principle;
	private Integer year;

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public double getPrinciple() {
		return principle;
	}

	public void setPrinciple(double principle) {
		this.principle = principle;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	public double getInterest(){
		return rate*principle*year*1.0d;
	}

	public Interests(float rate, double principle, Integer year) {
		super();
		this.rate = rate;
		this.principle = principle;
		this.year = year;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double principle = 0d;
		float rate = 0f;
		Integer year = 0;
		while(true){
			System.out.println("Please enter Principle : ");
			principle = sc.nextDouble();
			System.out.println("Please enter rate : ");
			rate = sc.nextFloat();
			System.out.println("Please enter time : ");
			year = sc.nextInt();
			if(principle >= 0 && rate >= 0 && year > 1){
				break;
			}else{
				continue;
			}
		}
		Interests interests = new Interests(rate, principle, year);
		int period = 1;
		while(period <= year){
			System.out.println(Math.ceil(rate*principle*year*1.0d));
			period++;
		}
		
	}
}
