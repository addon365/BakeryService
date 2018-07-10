package com.addon.BakeryService.models.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.addon.BakeryService.models.Customer;


public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
	Customer findByMobile(String mobile);
}
