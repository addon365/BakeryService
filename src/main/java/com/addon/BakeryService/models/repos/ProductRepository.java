package com.addon.BakeryService.models.repos;



import org.springframework.data.repository.PagingAndSortingRepository;

import com.addon.BakeryService.controllers.ProductController;
import com.addon.BakeryService.models.Product;


public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
	
	public Product findByModelNumber(String modelNumber);

	
//	@Query(value="SELECT * FROM product ORDER BY customid DESC LIMIT 1", nativeQuery = true)
//	public Product getMaxId();

//	@SQLUpdate(sql="DELETE product,order_item FROM product INNER JOIN order_item ON order_item.product_id = product.id WHERE product.id=:Id")
//	public void deleteById(@Param("Id")Long Id);

	
//	@Query(value="DELETE FROM product WHERE customid=1 ", nativeQuery = true)
//	public Product findByCustomid(Long customid);

	
}
