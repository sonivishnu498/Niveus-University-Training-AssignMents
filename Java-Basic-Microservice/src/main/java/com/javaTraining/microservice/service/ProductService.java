package com.javaTraining.microservice.service;

import java.util.List;

import com.javaTraining.microservice.entity.Product;

public interface ProductService {
	
	public List<Product> getAll();
	
	public Product addProduct(Product product);
	
	public Product getProductById(Long id);
	
	public void deleteProduct(Long id);

}
