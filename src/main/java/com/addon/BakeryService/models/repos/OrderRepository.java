package com.addon.BakeryService.models.repos;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.addon.BakeryService.models.Customer;
import com.addon.BakeryService.models.OrderStatus;
import com.addon.BakeryService.models.SalesOrder;

import ch.qos.logback.core.net.SyslogOutputStream;



public interface OrderRepository extends PagingAndSortingRepository<SalesOrder, Long> {
	public Iterable<SalesOrder> findByOrderStatus(OrderStatus orderStatus);
	
	
	public SalesOrder findByExpectedDate(LocalDate ExpectedDate);

	@Query("SELECT s FROM SalesOrder s WHERE (LOWER(s.orderStatus.name) != 'delivered' AND LOWER(s.orderStatus.name) !='cancelled')")
	public Iterable<SalesOrder> getNotDelivered();
	
	

//	@Query(value="SELECT * FROM sales_order ORDER BY customid DESC LIMIT 1", nativeQuery = true)
//	public SalesOrder getMaxId();
	
	@Query(value="SELECT * FROM sales_order WHERE shop_id =:shopId ORDER BY customid DESC LIMIT 1", nativeQuery = true)
	public SalesOrder getMaxShopId(@Param("shopId") Long shopId);

}
