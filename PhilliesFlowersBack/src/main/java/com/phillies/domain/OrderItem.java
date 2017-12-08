package com.phillies.domain;

public class OrderItem {
	private Flower item;
	private int quantity;

	public OrderItem() {
		super();
	}

	public OrderItem(Flower item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public Flower getItem() {
		return item;
	}

	public void setItem(Flower item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public float getCost() {
		return this.item.getPrice() * this.quantity;
	}
	
	public String getItemName() {
		return item.getName();
	}
}