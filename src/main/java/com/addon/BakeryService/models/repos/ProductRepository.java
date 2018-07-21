package com.addon.BakeryService.models.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.addon.BakeryService.models.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

	public Product findByModelNumber(String modelNumber);

}
