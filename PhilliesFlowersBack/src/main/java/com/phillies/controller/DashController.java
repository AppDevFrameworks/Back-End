package com.phillies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashController {

	@GetMapping("/login")
	public String getDash() {
		return "dash";
	}
}
