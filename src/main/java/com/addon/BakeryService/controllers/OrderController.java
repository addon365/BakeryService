package com.addon.BakeryService.controllers;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.addon.BakeryService.models.Customer;
import com.addon.BakeryService.models.OrderStatus;
import com.addon.BakeryService.models.SalesOrder;
import com.addon.BakeryService.models.repos.CustomerRepository;
import com.addon.BakeryService.models.repos.OrderRepository;
import com.addon.BakeryService.models.repos.OrderStatusRepository;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderStatusRepository orderStatusRepository;
	@Autowired
	CustomerRepository customerRepository;

	@GetMapping("/get")
	public Iterable<SalesOrder> getAll() {
		return orderRepository.findAll();
	}
	
	@GetMapping("/getOrders")
	public Iterable<SalesOrder> getOrders() {
		return orderRepository.getNotDelivered();
	}


	@GetMapping("/getSalesReport")
	public Iterable<SalesOrder> getSalesReport() {
		OrderStatus orderStatus = orderStatusRepository.findByName("Delivered");
		return orderRepository.findByOrderStatus(orderStatus);
	}

	@PostMapping("/add")
	public @ResponseBody SalesOrder add(@RequestBody SalesOrder salesOrder) {

		Customer customer = salesOrder.getCustomer();
		if (customer == null) {
			salesOrder.setCustomer(new Customer(1L));
		} else if (customer.getId() == -1) {
			customer = customerRepository.save(customer);
			salesOrder.setCustomer(customer);
		}
		salesOrder.setOrderedDate(LocalDate.now());
		salesOrder.setOrderedTime(LocalTime.now());
		return orderRepository.save(salesOrder);
	}

	@PostMapping("/edit")
	public @ResponseBody SalesOrder edit(@RequestBody SalesOrder salesOrder) {
		return orderRepository.save(salesOrder);
	}

	@GetMapping("/getStatuses")
	public Iterable<OrderStatus> getOrderStatuses() {
		return orderStatusRepository.findAll();
	}
}
