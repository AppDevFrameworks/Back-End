package com.phillies.services;

import java.util.ArrayList;
import java.util.List;

import com.phillies.domain.Order;
import com.phillies.domain.OrderItem;

public interface OrderService {
	public List<Order> getUserOrders(String name);
	public int getNextOrder();
	public Order getOrderbyId(int i);
	public void save(int id, ArrayList<OrderItem> items, String name);
	public void save(Order order);
}