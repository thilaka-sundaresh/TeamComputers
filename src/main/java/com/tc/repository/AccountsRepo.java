package com.tc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tc.dto.Accounts;
import com.tc.dto.Orders;

public interface AccountsRepo extends MongoRepository<Accounts,String>{

	
	@Query("{accountHolderName:'?0'}")
	Accounts findByName(String userName);
}
