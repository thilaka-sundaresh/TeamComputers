package com.tc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tc.dto.Orders;

public interface OrdersRepo extends MongoRepository<Orders,String>{

	@Query("{orderAccountId:'?0'}")
	List<Orders> findByAcountId(String orderAccountId);
}
