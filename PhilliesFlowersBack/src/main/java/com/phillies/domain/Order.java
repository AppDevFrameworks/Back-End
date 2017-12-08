package com.phillies.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {
	@Id
	private int id;
	private String orderAcc;
	private List<OrderItem> order;

	public Order() {
	}

	public Order(int id, List<OrderItem> order, String orderAcc) {
		this.id = id;
		this.order = order;
		this.orderAcc = orderAcc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<OrderItem> getOrders() {
		return order;
	}

	public void setOrderType(List<OrderItem> order) {
		this.order = order;
	}

	public String getOrderAcc() {
		return orderAcc;
	}

	public void setOrderAcc(String orderAcc) {
		this.orderAcc = orderAcc;
	}
}