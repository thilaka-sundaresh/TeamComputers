package com.tc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tc.dto.Inventory;

public interface InventoryRepo extends MongoRepository<Inventory,String>{

	
}
