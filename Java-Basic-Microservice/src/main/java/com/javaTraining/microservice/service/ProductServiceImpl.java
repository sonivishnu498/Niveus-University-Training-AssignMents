package com.javaTraining.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaTraining.microservice.entity.Product;
import com.javaTraining.microservice.repositoy.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo repo;

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return repo.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		Product product = repo.findById(id).get();
		return product;
	}

	@Override
	public void deleteProduct(Long id) {
		repo.deleteById(id);
		
		System.out.println("Product "+id+" deleted Successfully");
		
	}

}
