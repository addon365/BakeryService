package com.addon.BakeryService.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

import antlr.collections.List;

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
	public @ResponseBody Iterable<SalesOrder> getAll() {
		return orderRepository.findAll();
	}

	@GetMapping("/getOrders")
	public @ResponseBody Iterable<SalesOrder> getOrders() {
		return orderRepository.getNotDelivered();
	}

	@GetMapping("/getSalesReport")
	public @ResponseBody Iterable<SalesOrder> getSalesReport() {
		OrderStatus orderStatus = orderStatusRepository.findByName("Delivered");
		return orderRepository.findByOrderStatus(orderStatus);
	}

	@GetMapping("/getReportParam/{status}")
	public @ResponseBody Iterable<SalesOrder> getSalesReport(@PathVariable("status") String status) {
		OrderStatus orderStatus = orderStatusRepository.findByName(status);
		return orderRepository.findByOrderStatus(orderStatus);
	}

	@PostMapping("/add")
	public SalesOrder add(@RequestBody SalesOrder salesOrder) {

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

	@PostMapping("/moveToProduction")
	public @ResponseBody Iterable<SalesOrder> moveToProduction(@RequestBody ArrayList<SalesOrder> salesOrderList) {
		OrderStatus orderStatus = orderStatusRepository.findByName("InProduction");
		for (int i = 0; i < salesOrderList.size(); i++) {
			salesOrderList.get(i).setOrderStatus(orderStatus);
		}
		return orderRepository.saveAll(salesOrderList);

	}

	@PostMapping("/moveToStock")
	public @ResponseBody Iterable<SalesOrder> moveToStock(@RequestBody ArrayList<SalesOrder> salesOrderList) {
		OrderStatus orderStatus = orderStatusRepository.findByName("InStock");
		for (int i = 0; i < salesOrderList.size(); i++) {
			salesOrderList.get(i).setOrderStatus(orderStatus);
		}
		return orderRepository.saveAll(salesOrderList);

	}

	@PostMapping("/edit")
	public @ResponseBody SalesOrder edit(@RequestBody SalesOrder salesOrder) {
		return orderRepository.save(salesOrder);

	}

	@GetMapping("/getStatuses")
	public @ResponseBody Iterable<OrderStatus> getOrderStatuses() {
		return orderStatusRepository.findAll();
	}
}
