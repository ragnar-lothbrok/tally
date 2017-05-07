package com.he.capillary;

import java.util.ArrayList;

public class Purchase {

	private ArrayList<Lista> Lists = new ArrayList<Lista>();
	private int customerID;
	private String customerName;

	public void addList(String itemName, int quantity, double price) {
		this.Lists.add(new Lista(itemName, quantity, price));
	}

	public void updateItem(String itemName, int quantity, double price) {
		for (Lista list : Lists) {
			if (list.getItemName().equalsIgnoreCase(itemName)) {
				Lista temp = new Lista(itemName, quantity, price);
				list.setPrice(temp.getPrice());
				list.setQuantity(temp.getQuantity());
			}
		}
	}

	public double getTotalPrice() {
		double total = 0.0;
		for (Lista list : Lists) {
			total += list.getTotalPrice();
		}
		return total;
	}

	public Purchase(int customerID, String customerName) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
	}

	public String getList(String itemName) {
		for (Lista list : Lists) {
			if (list.getItemName().equalsIgnoreCase(itemName)) {
				return list.toString();
			}
		}
		return itemName + " not found.";
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("CustomerID=" + customerID + ", CustomerName=" + customerName + " ");
		for (Lista list : Lists) {
			sb.append(list.toString());
		}
		sb.append("Purchase Total $"+getTotalPrice());
		return sb.toString();
	}

}
