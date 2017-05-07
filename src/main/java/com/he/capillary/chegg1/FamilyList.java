package com.he.capillary.chegg1;

import java.io.BufferedReader;
import java.io.FileReader;

public class FamilyList {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("test.txt"));
			String line = br.readLine();
			while(line != null){
				
			}
		} catch (Exception exception) {
			System.out.println("Exception occured : " + exception);
		}

	}
}

class Family {
	private String id;
	private Integer numOfMembers;
	private float yearlyIncome;
	private String residence;

	public Family(String id, Integer numOfMembers, float yearlyIncome, String residence) {
		super();
		this.id = id;
		this.numOfMembers = numOfMembers;
		this.yearlyIncome = yearlyIncome;
		this.residence = residence;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNumOfMembers() {
		return numOfMembers;
	}

	public void setNumOfMembers(Integer numOfMembers) {
		this.numOfMembers = numOfMembers;
	}

	public float getYearlyIncome() {
		return yearlyIncome;
	}

	public void setYearlyIncome(float yearlyIncome) {
		this.yearlyIncome = yearlyIncome;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

}