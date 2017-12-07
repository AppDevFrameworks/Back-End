package com.phillies.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.phillies.domain.Order;

public interface OrderRepo extends MongoRepository<Order, String> {
	public Order findOrderById(int id);
}