package com.addon.BakeryService.models.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.addon.BakeryService.models.OrderStatus;
import com.addon.BakeryService.models.SalesOrder;

public interface OrderRepository extends PagingAndSortingRepository<SalesOrder, Long> {
	public Iterable<SalesOrder> findByOrderStatus(OrderStatus orderStatus);

	@Query("SELECT s FROM SalesOrder s WHERE LOWER(s.orderStatus.name) != LOWER(:statusName)")
	public Iterable<SalesOrder> getNotDelivered(@Param("statusName") String statusName);
}
