package com.addon.BakeryService.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class OrderItem {

	private Long id;

	private Product product;

	private double price;
	private double quantity;
	private UOM uom;
	private SalesOrder order;

	private Flavour flavour;

	@ManyToOne(targetEntity = Flavour.class, fetch = FetchType.EAGER)
	public Flavour getFlavour() {
		return flavour;
	}

	public void setFlavour(Flavour flavour) {
		this.flavour = flavour;
	}

	public void setUom(UOM uom) {
		this.uom = uom;
	}

	public OrderItem() {

	}

	@ManyToOne(targetEntity = UOM.class, fetch = FetchType.EAGER)
	public UOM getUom() {
		return uom;
	}

	public OrderItem(Product product, double price, int quantity) {
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	@ManyToOne
	public SalesOrder getOrder() {
		return order;
	}

	public void setOrder(SalesOrder order) {
		this.order = order;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
