package com.phillies.entities;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.phillies.domain.Flower;
import com.phillies.domain.Order;
import com.phillies.domain.OrderItem;
import com.phillies.services.AccountService;
import com.phillies.services.FlowerService;
import com.phillies.services.OrderService;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	AccountService accountService;
	@Autowired
	FlowerService flowerService;
	@Autowired
	OrderService orderService;
	String[] flowerName = { "Rose", "Tulip", "Daisy", "Carnation", "Lily", "Orchid", "Hypericum", "Sunflower" };
	double[] flowerPrice = { 0.80, 0.50, 0.45, 0.70, 0.90, 0.50, 0.75, 0.30 };
	Flower[] flowers = new Flower[flowerName.length];


	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		accountService.saveUser(1, "Phillies", "flowers", "user");
		accountService.saveUser(2, "Rob", "pass", "user");
		for (int i=0; i<flowerName.length; i++) {
			flowers[i] = new Flower(1+i, flowerName[i], flowerPrice[i]);
			flowerService.saveFlower(1+i, flowerName[i], flowerPrice[i]);
		}
		ArrayList<OrderItem> temp = new ArrayList<>();
		temp.add(new OrderItem(flowers[3], 1000));
		temp.add(new OrderItem(flowers[5], 3000));
		orderService.save(1, temp, "Phillies");
		temp.clear();
		temp.add(new OrderItem(flowers[5], 3000));
		temp.add(new OrderItem(flowers[6], 3000));
		orderService.save(2, temp, "Phillies");
		
		Order one = orderService.getOrderbyId(1);
		one.setPaid(400);
		orderService.save(one);
	}
}
