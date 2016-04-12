package com.he.capillary.chegg1;

public class Part {

	private String partNUmber;
	private String description;
	private double price;
	private String warehouseId;
	private Integer quantity;

	public String getPartNUmber() {
		return partNUmber;
	}

	public void setPartNUmber(String partNUmber) {
		this.partNUmber = partNUmber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Part(String partNUmber, String description, double price, String warehouseId, Integer quantity) {
		super();
		this.partNUmber = partNUmber;
		this.description = description;
		this.price = price;
		this.warehouseId = warehouseId;
		this.quantity = quantity;
	}

}
