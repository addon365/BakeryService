package com.addon.BakeryService.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	private long id;
	private String name;
	private int quantity;
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


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product(String name,double price) {
		this.name=name;
		this.price=price;
		
	}
	public Product(long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
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
