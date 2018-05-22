package com.addon.BakeryService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.addon.BakeryService.models.Customer;
import com.addon.BakeryService.models.repos.CustomerRepository;
import com.addon.BakeryService.models.repos.OrderRepository;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	@Autowired
	CustomerRepository customerRepository;

	@GetMapping("/find")
	public @ResponseBody Customer findCustomerByMobile(
			@RequestParam(value = "mobile", defaultValue = "99999999") String mobile) {
		return customerRepository.findByMobile(mobile);
	}

	@GetMapping("/get")
	public @ResponseBody Iterable<Customer> getAll() {
		return customerRepository.findAll();
	}

	
	@PostMapping("/add")

	public Customer add(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
}
