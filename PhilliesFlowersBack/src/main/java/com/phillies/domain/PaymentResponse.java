package com.phillies.domain;

public class PaymentResponse {
	private int code;
	private String token;

	public PaymentResponse(int code, String token) {
		this.code = code;
		this.token = token;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}