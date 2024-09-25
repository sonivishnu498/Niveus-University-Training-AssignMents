package com.javatraining.microservice.service;

import com.javatraining.microservice.entity.Product;
import com.javatraining.microservice.repositoy.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo repo;

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	public List<Product> getAll() {
		return repo.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		return repo.save(product);
	}

	@Override
	public Optional<Product> getProductById(Long id) {

		return  repo.findById(id);
	}

	@Override
	public void deleteProduct(Long id) {
		repo.deleteById(id);
		logger.info("product deleted");
		
	}

}
