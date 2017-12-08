package com.phillies.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phillies.domain.Order;
import com.phillies.domain.OrderItem;
import com.phillies.repository.OrderRepo;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	@Override
	public List<Order> getUserOrders(String name) {
		return orderRepo.findAllByOrderAcc(name);
	}

	@Override
	public Order getOrderbyId(int id) {
		return orderRepo.findAllById(id);
	}

	@Override
	public void save(int id, ArrayList<OrderItem> items, String name) {
		orderRepo.save(new Order(id, items, name));
	}
	
	@Override
	public void save(Order order) {
		orderRepo.save(order);
	}
}