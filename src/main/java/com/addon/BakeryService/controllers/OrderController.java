package com.addon.BakeryService.controllers;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.addon.BakeryService.models.Customer;
import com.addon.BakeryService.models.OrderStatus;
import com.addon.BakeryService.models.SalesOrder;
import com.addon.BakeryService.models.Shop;
import com.addon.BakeryService.models.Sms;
import com.addon.BakeryService.models.repos.CustomerRepository;
import com.addon.BakeryService.models.repos.OrderRepository;
import com.addon.BakeryService.models.repos.OrderStatusRepository;
import com.addon.BakeryService.models.repos.ShopRepository;

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
	@Autowired
	ShopRepository shopRepository;
	
	@GetMapping("/get")
	public @ResponseBody Iterable<SalesOrder> getAll() {
		return orderRepository.findAll();
	}

	@GetMapping("/getOrders")
	public @ResponseBody Iterable<SalesOrder> getOrders() {
		return orderRepository.getNotDelivered();
	}
	@GetMapping("/getCount")
	public @ResponseBody Iterable<Integer> getCounts() {
		
		return orderRepository.getCount();
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

		Shop shop = salesOrder.getShop();
		Customer customer = salesOrder.getCustomer();
			
			if (customer == null) {
				customer=customerRepository.findByMobile("0000000000");
			} else if (customer.getId() == -1) {
				customer = customerRepository.save(customer);
				salesOrder.setCustomer(customer);
			}
			Long shopId=shop.getId();
			LocalDate date = salesOrder.getExpectedDate();
			LocalDate date1Day = date.plus(1, ChronoUnit.DAYS);
			salesOrder.setExpectedDate(date1Day);
			salesOrder.setOrderedDate(LocalDate.now());
			 Long customid=Long.valueOf(0);
			if(orderRepository.getMaxShopId(shopId)!=null) 
				customid=orderRepository.getMaxShopId(shopId).getCustomid();
			salesOrder.setCustomid(customid+1);
			salesOrder.setOrderedTime(LocalTime.now());
			return orderRepository.save(salesOrder);
		
		}
		


	@PostMapping("/checkout")
	public SalesOrder checkout(@RequestBody SalesOrder salesOrder) {
		Shop shop = salesOrder.getShop();
		Customer customer = salesOrder.getCustomer();
		
		if (customer == null) {
			customer=customerRepository.findByMobile("0000000000");
			salesOrder.setCustomer(customer);
		} 
		Long shopId=shop.getId();
		salesOrder.setOrderedDate(LocalDate.now());
		 Long customid=Long.valueOf(0);
			if(orderRepository.getMaxShopId(shopId)!=null) 
				customid=orderRepository.getMaxShopId(shopId).getCustomid();
			salesOrder.setCustomid(customid+1);
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
		
//		Optional<SalesOrder> salesOrder1=orderRepository.findById(salesOrder.getId());
//		LocalDate serverdate=salesOrder1.get().getExpectedDate();
//		System.out.println("server"+serverdate);
//		LocalDate today=salesOrder.getExpectedDate();
//		System.out.println("cilent"+salesOrder.getExpectedDate());
//		
//		if(serverdate.equals(today)) {
//			System.out.println("hi");
//			
//			salesOrder.setExpectedDate(serverdate);
//		}else {
//			System.out.println("bye");
//			LocalDate date = today;
//			LocalDate date1Day = date.plus(1, ChronoUnit.DAYS);
//			salesOrder.setExpectedDate(date1Day);
//		}
		return orderRepository.save(salesOrder);
		
		

	}

	@GetMapping("/getStatuses")
	public @ResponseBody Iterable<OrderStatus> getOrderStatuses() {
		return orderStatusRepository.findAll();
	}
	@DeleteMapping("/delete/{id}")
	public @ResponseBody void deleteSalesorder(@RequestBody @PathVariable("id") Long Id) {
		orderRepository.deleteById(Id);
	}
	
}
