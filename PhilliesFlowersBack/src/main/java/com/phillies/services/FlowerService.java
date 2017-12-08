package com.phillies.services;

import java.util.List;

import com.phillies.domain.Flower;

public interface FlowerService {
	public Flower getFlowers(String name);
	public List<Flower> getAllFlowers();
	public void saveFlower(int id, String name, double price);
}