package com.he.chegg.member;

import java.util.UUID;

public class Member {

	private String id;
	private String firstname;
	private String lastname;
	private String gender;
	private String phonenumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Member(String firstname, String lastname, String gender, String phonenumber) {
		super();
		this.id = UUID.randomUUID().toString();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.phonenumber = phonenumber;
	}

	@Override
	public String toString() {
		return "MemberCard [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", phonenumber=" + phonenumber + "]";
	}

}
