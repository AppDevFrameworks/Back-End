package com.phillies.controller;

import java.util.ArrayList;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phillies.domain.Account;
import com.phillies.domain.Flower;
import com.phillies.domain.Order;
import com.phillies.domain.OrderItem;
import com.phillies.services.AccountService;
import com.phillies.services.FlowerService;
import com.phillies.services.OrderService;

@RestController
public class FrontController {

	@Autowired
	AccountService accountService;
	@Autowired
	OrderService orderService;
	@Autowired
	FlowerService flowerService;

	@PostMapping("/getOrder")
	public String greeting(@RequestParam(required = true) String name, @RequestParam(required = true) String pass,
			@RequestParam("item") String[] item) {
		String response = "{";
		Account acc = accountService.login(name, pass);
		if (acc != null) {
			ArrayList<OrderItem> order = addOrder(item);
			if (!order.isEmpty())
				orderService.save(new Order(orderService.getNextOrder(), order, acc.getName()));
			response += getCode(order);
		} else
			response += addResponse("code", "3");
		response += "}";
		return response;
	}

	public ArrayList<OrderItem> addOrder(String[] params) {
		ArrayList<OrderItem> order = new ArrayList<>();
		for (int i = 0; i < params.length; i++) {
			String[] values = params[i].split("-");
			if (values.length == 2) {
				Flower flower = flowerService.getFlowers(values[0]);
				int quantity = NumberUtils.createInteger(values[1]);
				if (flower != null) {
					if(!checkOrder(order, flower.getName(), quantity))
					order.add(new OrderItem(flower, quantity));
				}
			}
		}
		return order;
	}
	
	public boolean checkOrder(ArrayList<OrderItem> order, String flower, int quantity) {
		for(OrderItem o: order)
			if(o.getItemName().equalsIgnoreCase(flower)) {
				o.increment(quantity);
				return true;
			}
		return false;	
	}

	public String getCode(ArrayList<OrderItem> order) {
		if (order.isEmpty())
			return addResponse("code", "2");
		return addResponse("code", "1");
	}

	public String addResponse(String param, String value) {
		return "\"" + param + "\" : \"" + value + "\"";
	}
}