package com.javatraining.microservice.service;

import com.javatraining.microservice.entity.Product;

import java.util.List;
import java.util.Optional;



public interface ProductService {
	
	public List<Product> getAll();
	
	public Product addProduct(Product product);
	
	public Optional<Product> getProductById(Long id);
	
	public void deleteProduct(Long id);

}
