package com.phillies.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.phillies.domain.Account;
import com.phillies.repository.AccountRepo;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	AccountRepo accountRepo;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		accountRepo.save(new Account(1, "Jer", "pass"));
		accountRepo.save(new Account(2, "Rob", "pass"));
	}
}
