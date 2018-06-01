package com.addon.BakeryService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.addon.BakeryService.models.Shop;
import com.addon.BakeryService.models.repos.ShopRepository;

@RestController
@RequestMapping("/api/shop")
@CrossOrigin(origins = "http://localhost:4200")
public class ShopController {
	@Autowired
	ShopRepository shopRepository;

	@GetMapping("/get")
	public @ResponseBody Iterable<Shop> getAll() {
		return shopRepository.findAll();
	}

}
