package com.phillies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phillies.domain.Order;
import com.phillies.repository.OrderRepo;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	@Override
	public List<Order> getUserOrders(String name) {
		return orderRepo.findAllByOrderAcc(name);
	}
}