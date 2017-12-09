package com.phillies.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.phillies.domain.Order;

public interface OrderRepo extends MongoRepository<Order, String> {
	public List<Order> findAllByOrderAcc(String orderAcc);
	public Order findTopByOrderByIdDesc();
	public Order findAllById(int id);
}