package com.phillies.services;

import com.phillies.domain.Account;

public interface AccountService {
	public Account login(String name, String pass);
	public void saveUser(int id, String name, String pass, String type);
}