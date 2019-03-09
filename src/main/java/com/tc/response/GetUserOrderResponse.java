package com.tc.response;

import java.util.List;

public class GetUserOrderResponse {

	public List<OrderDetails> orders;

	public List<OrderDetails> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDetails> orders) {
		this.orders = orders;
	}
	
	
	
}
