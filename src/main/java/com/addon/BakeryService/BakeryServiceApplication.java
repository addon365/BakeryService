package com.addon.BakeryService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.addon.BakeryService.models.Customer;
import com.addon.BakeryService.models.OrderItem;
import com.addon.BakeryService.models.OrderStatus;
import com.addon.BakeryService.models.Product;
import com.addon.BakeryService.models.SalesOrder;
import com.addon.BakeryService.models.Shop;
import com.addon.BakeryService.models.repos.CustomerRepository;
import com.addon.BakeryService.models.repos.OrderRepository;
import com.addon.BakeryService.models.repos.OrderStatusRepository;
import com.addon.BakeryService.models.repos.ProductRepository;
import com.addon.BakeryService.models.repos.ShopRepository;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = { "com.addon.BakeryService.models" })
public class BakeryServiceApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	ShopRepository shopRepository;
	@Autowired
	OrderStatusRepository orderStatusRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	OrderRepository orderRepository;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BakeryServiceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BakeryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Customer customer = new Customer("Dummy", "9999999999", "2222222222");
		// customerRepository.save(customer);

		if (shopRepository.count() == 0) {

			List<Shop> shops = new ArrayList<Shop>(3);
			shops.add(new Shop("Madhura", "Madhura"));
			shops.add(new Shop("Cauvery", "Cauvery"));
			shops.add(new Shop("Yamunai", "Yamunai"));
			shopRepository.saveAll(shops);
		}
		if (orderStatusRepository.count() == 0) {
			List<OrderStatus> orderStatuses = new ArrayList<OrderStatus>(4);
			orderStatuses.add(new OrderStatus("Delivered", "D"));
			orderStatuses.add(new OrderStatus("InProduction", "IP"));
			orderStatuses.add(new OrderStatus("InStock", "IS"));
			orderStatuses.add(new OrderStatus("Pending", "P"));
			orderStatusRepository.saveAll(orderStatuses);
		}
		if (productRepository.count() == 0) {
			List<Product> products = new ArrayList<Product>(2);
			products.add(new Product("CupCake", 10.00));
			products.add(new Product("Bread", 25.00));
			productRepository.saveAll(products);

		}
		// Set<OrderItem> orderItems = new HashSet<OrderItem>(2);
		// orderItems.add(new OrderItem(products.get(0), 10, 2));
		// orderItems.add(new OrderItem(products.get(1), 25, 2));
		// SalesOrder order = new SalesOrder();
		// order.setCustomer(customer);
		// order.setAdvance(200);
		// order.setTotal(0);
		// order.setOrderedDate(LocalDate.now());
		// order.setOrderedTime(LocalTime.now());
		// order.setExpectedDate(LocalDate.of(2018, 5, 15));
		// order.setExpectedTime(LocalTime.of(11, 20));
		// order.setShop(shops.get(0));
		// order.setOrderStatus(orderStatuses.get(0));
		//
		// order.setOrderItems(orderItems);
		// orderRepository.save(order);
	}

}
