package com.tc.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Inventory")
public final class Inventory {

	@Id
	public String _id;
	
    @Field("inventoryName")
    public String inventoryName;
    
    @Field("numberOfPiecesLeft")
    public int numberOfPiecesLeft;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public int getNumberOfPiecesLeft() {
		return numberOfPiecesLeft;
	}

	public void setNumberOfPiecesLeft(int numberOfPiecesLeft) {
		this.numberOfPiecesLeft = numberOfPiecesLeft;
	}    
}
