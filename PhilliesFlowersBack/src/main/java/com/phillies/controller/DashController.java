package com.phillies.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.phillies.config.SecurityConfig;
import com.phillies.domain.Account;
import com.phillies.domain.Order;
import com.phillies.services.OrderService;

@Controller
public class DashController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/dash")
	public String getDash(HttpSession session, Model model) {
		Account acc = (Account) session.getAttribute("user");
		if(acc==null)
			return "redirect:/login";
		List<Order> orders = orderService.getUserOrders(acc.getName());
		model.addAttribute("user", acc);
		model.addAttribute("orders", orders);
		session.setAttribute("token", SecurityConfig.getToken());
		model.addAttribute("token", session.getAttribute("token"));
		return "dash";
	}
}