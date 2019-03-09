package com.tc.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Accounts")
public final class Accounts {

	@Id
    public String _id;
	
    @Field("accountHolderName")
    public String accountHolderName;

    @Field("totalOrdersMade")
    public int totalOrdersMade;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getTotalOrdersMade() {
		return totalOrdersMade;
	}

	public void setTotalOrdersMade(int totalOrdersMade) {
		this.totalOrdersMade = totalOrdersMade;
	}
    
    
}
