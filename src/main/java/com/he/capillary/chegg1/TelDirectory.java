package com.he.capillary.chegg1;

public class TelDirectory implements Comparable<TelDirectory> {

	private String name;
	private String phonenumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public TelDirectory(String name, String phonenumber) {
		super();
		this.name = name;
		this.phonenumber = phonenumber;
	}

	public int compareTo(TelDirectory o) {
		int result = this.getName().compareTo(o.getName());
		if (result == 0) {
			return this.getPhonenumber().compareTo(o.getPhonenumber());
		}
		return result;
	}

	@Override
	public String toString() {
		return "TelDirectory [name=" + name + ", phonenumber=" + phonenumber + "]";
	}

}
