package com.phillies.services;

import com.phillies.domain.Flower;

public interface FlowerService {
	public Flower getFlowers(String name);
	public void saveFlower(int id, String name, double price);
}