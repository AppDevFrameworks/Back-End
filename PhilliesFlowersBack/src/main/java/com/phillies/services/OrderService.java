package com.phillies.services;

import java.util.List;

import com.phillies.domain.Order;

public interface OrderService {
	public List<Order> getUserOrders(String name);
}