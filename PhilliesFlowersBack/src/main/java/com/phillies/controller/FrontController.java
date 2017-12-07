package com.phillies.controller;

import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.phillies.repository.OrderRepo;

@RestController
public class FrontController {

	//@Autowired OrderRepo orderRep;
	
    @PostMapping("/getOrder")
    public String greeting(@RequestParam String item, @RequestParam String amount) {
    	System.out.println("A total of " + amount + " " + item + "(s) ordered!");
        return "Order Failed";
    }
}