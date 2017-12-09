package com.phillies.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phillies.domain.Flower;
import com.phillies.services.FlowerService;

@RestController
public class CheckController {
	
	@Autowired
	FlowerService flowerService;
	
	@GetMapping("/getItems")
	public List<Flower> itemsSale() {
		List<Flower> flowers = flowerService.getAllFlowers();
		return flowers;
	}
	
	/* 
	 * Just query with getItems and all items will be returned
	 */
}