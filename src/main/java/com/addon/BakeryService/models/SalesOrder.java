package com.addon.BakeryService.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SalesOrder {

	private Long id;
	private Long customId;
	private Customer customer;
	private double advance;
	private double total;
	private LocalDate orderedDate;
	private LocalDate expectedDate;
	private LocalTime orderedTime;
	private LocalTime expectedTime;
	private OrderStatus orderStatus;
	private Shop shop;
	private String message;
	private String comments;
	private Set<OrderItem> orderItems;

	public SalesOrder() {

	}

	public String getMessage() {
		return message;
	}

	public Long getCustomid() {
		return customId;
	}

	public void setCustomid(Long customid) {
		customId = customid;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@OneToMany(cascade = CascadeType.ALL)
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
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
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@OneToOne
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@OneToOne
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getAdvance() {
		return advance;
	}

	public void setAdvance(double advance) {
		this.advance = advance;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDate getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}

	public LocalDate getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(LocalDate expectedDate) {
		this.expectedDate = expectedDate;
	}

	public LocalTime getOrderedTime() {
		return orderedTime;
	}

	public void setOrderedTime(LocalTime orderedTime) {
		this.orderedTime = orderedTime;
	}

	public LocalTime getExpectedTime() {
		return expectedTime;
	}

	public void setExpectedTime(LocalTime expectedTime) {
		this.expectedTime = expectedTime;
	}

}
