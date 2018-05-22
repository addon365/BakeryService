package com.addon.BakeryService.models.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.addon.BakeryService.models.OrderStatus;

public interface OrderStatusRepository extends PagingAndSortingRepository<OrderStatus, Long> {
	public OrderStatus findByName(String name);
}
