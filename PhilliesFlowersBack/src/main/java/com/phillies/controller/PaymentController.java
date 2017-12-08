package com.phillies.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phillies.config.SecurityConfig;
import com.phillies.domain.Order;
import com.phillies.services.OrderService;

@RestController
public class PaymentController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/payOrder")
	public String payOrder(@RequestParam String order, @RequestParam String payment, @RequestParam String token,
			HttpSession session) {
		String response = "{";
		System.out.println(token + " - " + session.getAttribute("token"));
		if (session.getAttribute("user") != null && token.equals(session.getAttribute("token"))) {
			int orderId = NumberUtils.createInteger(order);
			double dPay = NumberUtils.createDouble(payment);
			Order temp = orderService.getOrderbyId(orderId);
			int lodge = temp.lodgePayment(dPay);
			response += addResponse("code", lodge+"");
			if (lodge == 1)
				orderService.save(temp);
		} else
			response += addResponse("code", "3");
		session.setAttribute("token", SecurityConfig.getToken());
		response += "," + addResponse("token", (String) session.getAttribute("token")) + "}";
		return response;
	}

	public String addResponse(String param, String value) {
		return "\"" + param + "\" : \"" + value + "\"";
	}
}