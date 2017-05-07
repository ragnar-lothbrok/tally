package com.he.capillary;

public class Lista {

	private String itemName;
	private int quantity;
	private double price;

	public String getItemName() {
		return itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Lista(String itemName, int quantity, double price) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public String toString() {
		return ""+this.getItemName()+" qty "+this.getQuantity()+" @ $"+this.getPrice()+" $"+this.getTotalPrice()+" ";
	}
	
	double getTotalPrice(){
		return this.getPrice()*this.getQuantity();
	}

}
