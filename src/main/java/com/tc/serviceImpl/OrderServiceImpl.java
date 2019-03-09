package com.tc.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tc.dto.Accounts;
import com.tc.dto.Inventory;
import com.tc.dto.Orders;
import com.tc.repository.AccountsRepo;
import com.tc.repository.InventoryRepo;
import com.tc.repository.OrdersRepo;
import com.tc.request.CheckUserRequest;
import com.tc.request.CreateOrderRequest;
import com.tc.request.GetUserOrderRequest;
import com.tc.response.CheckUserResponse;
import com.tc.response.CreateOrderResponse;
import com.tc.response.GetAllInventoriesResponse;
import com.tc.response.GetUserOrderResponse;
import com.tc.response.OrderDetails;
import com.tc.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	AccountsRepo accountsRepo;
	
	@Autowired
	InventoryRepo inventoryRepo;
	
	@Autowired
	OrdersRepo ordersRepo;
	
	public CreateOrderResponse createOrder(CreateOrderRequest request) {
		CreateOrderResponse createOrderResponse= new CreateOrderResponse();
		
		//create a order
		Orders createOne= new Orders();
		createOne.setInventoryId(request.getItemId());
		createOne.setNumberOfItems(request.getNumberOfItems());
		createOne.setOrderAccountId(request.getUserId());
		createOne.setOrderPlacedOn(new Date());
		
		//before placing order check if inventory exists
		Optional<Inventory> inventoryDetails=inventoryRepo.findById(request.getItemId());
		if(inventoryDetails != null && inventoryDetails.get().getNumberOfPiecesLeft() >= request.getNumberOfItems()){//if required number of inventory exists, Place order
			inventoryDetails.get().setNumberOfPiecesLeft(inventoryDetails.get().getNumberOfPiecesLeft()-request.getNumberOfItems());
			inventoryRepo.save(inventoryDetails.get());// change number of pieces left
			createOne=ordersRepo.save(createOne);
			
			Optional<Accounts> accountDetails=accountsRepo.findById(request.getUserId());
			if(accountDetails != null){
				accountDetails.get().setTotalOrdersMade(accountDetails.get().getTotalOrdersMade()+1);
				accountsRepo.save(accountDetails.get());//change total orders made by user
				createOrderResponse.setOrderId(createOne.get_id());
				createOrderResponse.setStatus("success..!!");
			}else{
				System.out.println("No account Details");
			}
			
		}else{//If required  number of inventory dosnt exists, failure msg
			System.out.println("No Inventory Details");
			createOrderResponse.setOrderId(createOne.get_id());
			createOrderResponse.setStatus("Item out of stock..!!");
		}
		
		return createOrderResponse;
	}

	public GetUserOrderResponse getUserOrder(GetUserOrderRequest request) {
		GetUserOrderResponse getUserOrderResponse= new GetUserOrderResponse();
		
		List<Orders> orderHistory=ordersRepo.findByAcountId(request.getUserId());
		List<OrderDetails> orders= new ArrayList<OrderDetails>();
		
		for(int i=0;i<orderHistory.size();i++){
			OrderDetails orderDetails= new OrderDetails();
			orderDetails.setItemId(orderHistory.get(i).getInventoryId());
			orderDetails.setItemName(inventoryRepo.findById(orderHistory.get(i).getInventoryId()).get().getInventoryName());
			orderDetails.setItemQuantity(orderHistory.get(i).getNumberOfItems());
			orderDetails.setOrderId(orderHistory.get(i).get_id());
			orders.add(orderDetails);
		}
		getUserOrderResponse.setOrders(orders);
		return getUserOrderResponse;
	}

	public GetAllInventoriesResponse getAllInventories() {
		GetAllInventoriesResponse getAllInventoriesResponse= new GetAllInventoriesResponse();
		List<Inventory> inventories=inventoryRepo.findAll();
		getAllInventoriesResponse.setInventories(inventories);
		return getAllInventoriesResponse;
	}

	public CheckUserResponse checkUser(CheckUserRequest request) {
		CheckUserResponse CheckUserResponse= new CheckUserResponse();
		
		Accounts user= accountsRepo.findByName(request.getUsername());
		
		if(user != null){
			CheckUserResponse.setId(user.get_id());
			CheckUserResponse.setStatus("success");
		}else{
			CheckUserResponse.setId("");
			CheckUserResponse.setStatus("User noy Found");
		}
		return CheckUserResponse;
	}

}
