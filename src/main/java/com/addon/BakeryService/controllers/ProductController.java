package com.addon.BakeryService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.addon.BakeryService.errors.CustomError;
import com.addon.BakeryService.models.Product;
import com.addon.BakeryService.models.SalesOrder;
import com.addon.BakeryService.models.repos.ProductRepository;

@RestController
@RequestMapping("/api/product")

@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/get")
	public @ResponseBody Iterable<Product> getAll() {
		return productRepository.findAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Product product) {
		if (productRepository.findByModelNumber(product.getModelNumber()) != null) {
			return new ResponseEntity<CustomError>(new CustomError("Model number Already Found"), HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Product>(productRepository.save(product), HttpStatus.CREATED);
	}

	@PostMapping("/edit")
	public @ResponseBody Product edit(@RequestBody Product product) {
		productRepository.save(product);
		return product;
	}
}
