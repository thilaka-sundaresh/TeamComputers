package com.tc.response;

public class InventoryDetails {

	public String inventoryId;
	public String inventoryName;
	public String quantityLeft;
	public String numberOfOrders;
	
	public String getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	public String getQuantityLeft() {
		return quantityLeft;
	}
	public void setQuantityLeft(String quantityLeft) {
		this.quantityLeft = quantityLeft;
	}
	public String getNumberOfOrders() {
		return numberOfOrders;
	}
	public void setNumberOfOrders(String numberOfOrders) {
		this.numberOfOrders = numberOfOrders;
	}
	
	
}
