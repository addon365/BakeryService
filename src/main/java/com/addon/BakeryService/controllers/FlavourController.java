package com.addon.BakeryService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.addon.BakeryService.models.Flavour;
import com.addon.BakeryService.models.Shop;
import com.addon.BakeryService.models.repos.FlavourRepository;

@RestController
@RequestMapping("/api/flavours")
@CrossOrigin(origins = "http://localhost:4200")
public class FlavourController {

	@Autowired
	private FlavourRepository flavourRepository;

	@GetMapping("/get")
	public @ResponseBody Iterable<Flavour> getAll() {
		return flavourRepository.findAll();
	}

	@PostMapping("/add")
	public @ResponseBody Flavour add(@RequestBody Flavour flavour) {
		return flavourRepository.save(flavour);
	}
	@PostMapping("/edit")
	public @ResponseBody Flavour edit(@RequestBody Flavour flavour) {
		flavourRepository.save(flavour);
		return flavour;
	}
}
