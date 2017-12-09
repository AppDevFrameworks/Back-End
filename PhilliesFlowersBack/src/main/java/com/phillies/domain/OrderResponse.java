package com.phillies.domain;

public class OrderResponse {
	private int code;

	public OrderResponse(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}