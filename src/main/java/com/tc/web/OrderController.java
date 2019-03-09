package com.tc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tc.request.CheckUserRequest;
import com.tc.request.CreateOrderRequest;
import com.tc.request.GetUserOrderRequest;
import com.tc.response.CheckUserResponse;
import com.tc.response.CreateOrderResponse;
import com.tc.response.GetAllInventoriesResponse;
import com.tc.response.GetUserOrderResponse;
import com.tc.service.IOrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {
	
	@Autowired
	IOrderService orderService;

	@RequestMapping(value="/createOrder",method=RequestMethod.POST)
	public CreateOrderResponse createOrder(@RequestBody CreateOrderRequest request){
		CreateOrderResponse response=orderService.createOrder(request);
		return response;
	}
	
	@RequestMapping(value="/getUserOrders",method=RequestMethod.POST)
	public GetUserOrderResponse getUserOrder(@RequestBody GetUserOrderRequest request){
		GetUserOrderResponse response=orderService.getUserOrder(request);
		return response;
	}
	
	@RequestMapping(value="/getAllInventories",method=RequestMethod.GET)
	public GetAllInventoriesResponse getAllInventories(){
		GetAllInventoriesResponse response=orderService.getAllInventories();
		return response;
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public CheckUserResponse checkUser(@RequestBody CheckUserRequest request){
		CheckUserResponse response=orderService.checkUser(request);
		return response;
	}
	
}
