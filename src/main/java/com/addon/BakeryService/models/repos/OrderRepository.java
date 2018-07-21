package com.addon.BakeryService.models.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.addon.BakeryService.models.OrderStatus;
import com.addon.BakeryService.models.SalesOrder;



public interface OrderRepository extends PagingAndSortingRepository<SalesOrder, Long> {
	public Iterable<SalesOrder> findByOrderStatus(OrderStatus orderStatus);

	@Query("SELECT s FROM SalesOrder s WHERE LOWER(s.orderStatus.name) != 'delivered'")
	public Iterable<SalesOrder> getNotDelivered();
	
	public SalesOrder findAllByOrderByCustomidAsc();
	

	@Query(value="SELECT * FROM sales_order ORDER BY customid DESC LIMIT 1", nativeQuery = true)
	public SalesOrder getMaxId();
}
