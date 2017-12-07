package com.phillies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phillies.domain.Account;
import com.phillies.services.AccountService;

@Controller
public class LoginController {

	@Autowired
	private AccountService accountService;

	/*
	 * @Autowired public void setAccountServices(AccountService accountService) {
	 * this.accountService = accountService; }
	 */

	@GetMapping("/login")
	public String login(Model model) {
		if (!model.containsAttribute("user"))
			return "login";
		return "index";
	}

	@PostMapping("/login")
	public String processLogin(Model model, @RequestParam String name, @RequestParam String pass) {
		Account account = (Account) getAccount(name, pass);
		if (account==null)
			return "login";
		else {
			model.addAttribute("user", account);
			return "index";
		}
	}

	public Account getAccount(String name, String pass) {
		return accountService.login(name, pass);
	}
}