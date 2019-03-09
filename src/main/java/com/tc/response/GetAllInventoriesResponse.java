package com.tc.response;

import java.util.List;

import com.tc.dto.Inventory;

public class GetAllInventoriesResponse {

	public List<Inventory> inventories;

	public List<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}
	
	
}
