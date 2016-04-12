package com.he.capillary.chegg1;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
	private String warehouseId;
	private String city;
	private String state;

	private List<Part> partList = new ArrayList<Part>();

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Warehouse(String warehouseId, String city, String state) {
		super();
		this.warehouseId = warehouseId;
		this.city = city;
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((warehouseId == null) ? 0 : warehouseId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Warehouse other = (Warehouse) obj;
		if (warehouseId == null) {
			if (other.warehouseId != null)
				return false;
		} else if (!warehouseId.equals(other.warehouseId))
			return false;
		return true;
	}

	public List<Part> getPartList() {
		return partList;
	}

	public void setPartList(List<Part> partList) {
		this.partList = partList;
	}

}
