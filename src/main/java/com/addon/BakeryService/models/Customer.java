package com.addon.BakeryService.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	
	private Long id;
	
	private String name;
	private String mobile;
	private String alternateMobile;
	
	public Customer() {}
	public Customer(Long id) {
		this.id=id;
	}
	public Customer(String name,String mobile,String alternateMobile) {
		this.name=name;
		this.mobile=mobile;
		this.alternateMobile=alternateMobile;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAlternateMobile() {
		return alternateMobile;
	}
	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}
	
	
}
