package com.he.capillary;

public class BankAccount {

	private Double customerBalance;
	private String customerID;
	private String customerName;

	public Double getCustomerBalance() {
		return customerBalance;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public BankAccount(Double customerBalance, String customerID, String customerName) {
		super();
		this.customerBalance = customerBalance;
		this.customerID = customerID;
		this.customerName = customerName;
	}

	public synchronized void withdraw(double amount) {
		this.customerBalance -= amount;
	}

	public synchronized void deposit(double amount) {
		this.customerBalance += amount;
	}

}
