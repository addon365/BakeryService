package com.addon.BakeryService.models.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.addon.BakeryService.models.OrderStatus;
import com.addon.BakeryService.models.SalesOrder;

public interface OrderRepository extends PagingAndSortingRepository<SalesOrder, Long> {
	public Iterable<SalesOrder> findByOrderStatus(OrderStatus orderStatus);
}
