package com.addon.BakeryService.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.addon.BakeryService.models.SalesOrder;
import com.addon.BakeryService.models.repos.OrderRepository;


@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;
	
	@GetMapping("/get")
	public Iterable<SalesOrder> getAll(){
		return orderRepository.findAll();
	}
	
	@PostMapping("/add")
	public @ResponseBody SalesOrder add(@RequestBody SalesOrder salesOrder){
		return orderRepository.save(salesOrder);
	}
}
