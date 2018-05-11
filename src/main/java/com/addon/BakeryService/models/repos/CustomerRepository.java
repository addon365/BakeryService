package com.addon.BakeryService.models.repos;
import org.springframework.data.repository.CrudRepository;

import com.addon.BakeryService.models.Customer;
public interface CustomerRepository extends CrudRepository<Customer,Long> {


}
