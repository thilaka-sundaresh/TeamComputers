package com.tc.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Orders")
public final class Orders {
	
	@Id
    public String _id;
	
    @Field("inventoryId")
    public String inventoryId;
    
    @Field("orderAccountId")
    public String orderAccountId;
    
    @Field("orderPlacedOn")
    public Date orderPlacedOn;
    
    @Field("numberOfItems")
    public int numberOfItems;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getOrderAccountId() {
		return orderAccountId;
	}

	public void setOrderAccountId(String orderAccountId) {
		this.orderAccountId = orderAccountId;
	}

	public Date getOrderPlacedOn() {
		return orderPlacedOn;
	}

	public void setOrderPlacedOn(Date orderPlacedOn) {
		this.orderPlacedOn = orderPlacedOn;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
    
    

}
