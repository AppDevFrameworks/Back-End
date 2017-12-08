package com.phillies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.phillies.domain.Account;
import com.phillies.repository.AccountRepo;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	private AccountRepo accountRepo;
	@Autowired
	private BCryptPasswordEncoder passEncoder;

	@Override
	public Account login(String name, String pass) {
		Account temp = accountRepo.findByNameIgnoreCase(name);
		System.out.println(name + " " + pass);
		if(passEncoder.matches(pass, temp.getPassword())) {
			return temp;
		}
		return null;
	}

	@Override
	public void saveUser(int id, String name, String pass, String type) {
		accountRepo.save(new Account(id, name, passEncoder.encode(pass)));
	}
}