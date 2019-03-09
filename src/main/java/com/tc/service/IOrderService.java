package com.tc.service;

import com.tc.request.CheckUserRequest;
import com.tc.request.CreateOrderRequest;
import com.tc.request.GetUserOrderRequest;
import com.tc.response.CheckUserResponse;
import com.tc.response.CreateOrderResponse;
import com.tc.response.GetAllInventoriesResponse;
import com.tc.response.GetUserOrderResponse;

public interface IOrderService {

	CreateOrderResponse createOrder(CreateOrderRequest request);

	GetUserOrderResponse getUserOrder(GetUserOrderRequest request);

	GetAllInventoriesResponse getAllInventories();

	CheckUserResponse checkUser(CheckUserRequest request);

}
