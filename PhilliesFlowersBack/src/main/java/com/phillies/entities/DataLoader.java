package com.phillies.entities;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.phillies.domain.Flower;
import com.phillies.domain.Order;
import com.phillies.domain.OrderItem;
import com.phillies.repository.FlowerRepo;
import com.phillies.repository.OrderRepo;
import com.phillies.services.AccountService;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	AccountService accountService;
	@Autowired
	FlowerRepo flowerRepo;
	@Autowired
	OrderRepo orderRepo;
	String[] flowerName = { "Rose", "Tulip", "Daisy", "Carnation", "Lily", "Orchid", "Hypericum", "Sunflower" };
	float[] flowerPrice = { (float) 0.80, (float) 0.50, (float) 0.45, (float) 0.70, (float) 0.90, (float) 0.50,
			(float) 0.75, (float) 0.30 };
	Flower[] flowers = new Flower[flowerName.length];
	

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		accountService.saveUser(1, "Phillies", "flowers", "user");
		accountService.saveUser(2, "Rob", "pass", "user");
		for (int i=0; i<flowerName.length; i++) {
			flowers[i] = new Flower(1+i, flowerName[i], flowerPrice[i]);
			flowerRepo.save(flowers[i]);
		}
	ArrayList<OrderItem> temp = new ArrayList<>();
	temp.add(new OrderItem(flowers[3], 1000));
	temp.add(new OrderItem(flowers[5], 3000));
	orderRepo.save(new Order(1, temp, "Phillies"));
	}
}
