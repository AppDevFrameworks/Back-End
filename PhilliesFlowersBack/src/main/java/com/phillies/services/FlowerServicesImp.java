package com.phillies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phillies.domain.Flower;
import com.phillies.repository.FlowerRepo;

@Service
public class FlowerServicesImp implements FlowerService {
	
	@Autowired
	private FlowerRepo flowerRepo;
	
	public Flower getFlowers(String name) {
		return flowerRepo.findByNameIgnoreCase(name);
	}

	@Override
	public void saveFlower(int id, String name, double price) {
		flowerRepo.save(new Flower(id, name, price));
	}
}