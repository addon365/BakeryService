package com.addon.BakeryService.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.addon.BakeryService.models.OrderStatus;

public interface OrderStatusRepository extends CrudRepository<OrderStatus,Long> {

}
