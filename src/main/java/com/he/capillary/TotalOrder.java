package com.he.capillary;

public class TotalOrder {

	private Item[] itemList = new Item[10];
	private double totalOrder;

	public static void main(String[] args) {
		TotalOrder to = new TotalOrder();
		to.fillData();
		System.out.println(to.totalOrder());
	}

	/**
	 * Will fill random data
	 */
	public void fillData() {
		for (int i = 0; i < itemList.length; i++) {
			itemList[i] = new Item(Math.abs(Math.random()*10));
		}
	}
	
	/**
	 * Method will calculate total value.
	 * @return
	 */
	public double totalOrder() {
		for (Item item : itemList) {
			this.totalOrder += item.getPrice();
		}
		return this.totalOrder;
	}

	static class Item {
		private double price;

		public Item(double price) {
			super();
			this.price = price;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

	}

}
