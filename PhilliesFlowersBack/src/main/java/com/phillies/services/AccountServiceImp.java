package com.phillies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phillies.domain.Account;
import com.phillies.repository.AccountRepo;

@Service
public class AccountServiceImp implements AccountService {

	private AccountRepo accountRepo;
	
	@Autowired
	public AccountServiceImp(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}
	
	@Override
	public Account login(String name, String pass) {
		return accountRepo.findByNameIgnoreCaseAndPassword(name, pass);
	}
}