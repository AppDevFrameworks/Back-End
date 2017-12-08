package com.phillies.controller;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phillies.domain.Order;
import com.phillies.services.OrderService;

@RestController
public class PaymentController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/payOrder")
	public String payOrder(@RequestParam String order, @RequestParam String payment, @RequestParam String token) {
		System.out.println(order + " - " + payment + " - " + token);
		int orderId = NumberUtils.createInteger(order);
		double dPay = NumberUtils.createDouble(payment);
		Order temp = orderService.getOrderbyId(orderId);
		String ret = "{\"outcome\" : " +temp.lodgePayment(dPay) +"}";
		orderService.save(temp);
		return ret;
	}
}