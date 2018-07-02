package com.addon.BakeryService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.addon.BakeryService.models.UOM;
import com.addon.BakeryService.models.repos.UOMRepository;

@RestController
@RequestMapping("/api/uom")
@CrossOrigin(origins = "http://localhost:4200")
public class UOMController {

	@Autowired
	UOMRepository uomRepository;

	@GetMapping("/get")
	public @ResponseBody Iterable<UOM> getAll() {
		return uomRepository.findAll();
	}

}
