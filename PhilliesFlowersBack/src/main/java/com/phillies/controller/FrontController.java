package com.phillies.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.phillies.repository.OrderRepo;

@RestController
public class FrontController {

	//@Autowired OrderRepo orderRep;
	
    @RequestMapping("/getOrder")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return "hello";
    }
}