package com.addon.BakeryService.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	private Long id;
	private String name;
	private double quantity;
	private double price;
	private String modelNumber;
	
	public Product()
	{
		
	}
	
	
	public String getModelNumber() {
		return modelNumber;
	}


	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}


	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Product(String name,double price, double quantity, String modelNumber ) {
		this.name=name;
		this.price=price;
		this.modelNumber=modelNumber;
		this.quantity=quantity;
	}
	public Product(Long id, String name, double price,String modelNumber) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.modelNumber=modelNumber;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	
	
}
