package com.phillies.restcontroller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phillies.config.SecurityConfig;
import com.phillies.domain.Order;
import com.phillies.domain.PaymentResponse;
import com.phillies.services.OrderService;

@RestController
public class PaymentController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/payOrder")
	public PaymentResponse payOrder(@RequestParam String order, @RequestParam String payment, @RequestParam String token,
			HttpSession session) {
		int code = 0;
		if (session.getAttribute("user") != null && token.equals(session.getAttribute("token"))) {
			Order temp = createOrder(order, payment);
			double dPay = NumberUtils.createDouble(payment);
			code = temp.lodgePayment(dPay);
			if (code == 1) {
				orderService.save(temp);
			}
		}
		else if (session.getAttribute("user") == null) 
			code = 3;
		else if(!token.equals(session.getAttribute("token")))
			code = 4;
			session.setAttribute("token", SecurityConfig.getToken());
			return new PaymentResponse(code, (String) session.getAttribute("token"));
	}
	
	public Order createOrder(String order, String payment) {
		int orderId = NumberUtils.createInteger(order);
		Order temp = orderService.getOrderbyId(orderId);
		return temp;
	}
	/* Codes
	 * 0 = Unknown
	 * 1 = Success
	 * 2 = Payment more than owed
	 * 3 = No session
	 * 4 = Token mismatch
	 * 
	 * This is for a jQuery so API not needed.
	*/
	
}