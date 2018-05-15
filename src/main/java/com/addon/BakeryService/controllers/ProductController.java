package com.addon.BakeryService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.addon.BakeryService.models.Product;
import com.addon.BakeryService.models.repos.ProductRepository;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/all")
	public @ResponseBody Iterable<Product> getAll() {
		return productRepository.findAll();
	}

	@PostMapping("/add")
	public Product add(@RequestBody Product product) {

		productRepository.save(product);
		return product;

	}

}
