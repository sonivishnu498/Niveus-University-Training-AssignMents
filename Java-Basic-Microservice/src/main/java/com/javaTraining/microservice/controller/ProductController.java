package com.javaTraining.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaTraining.microservice.entity.Product;
import com.javaTraining.microservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/getAll")
	public List<Product> getAllProduct(){
		return productService.getAll();
	}
	
	@PostMapping("/add-product")
	public Product addProduct(@RequestBody Product product) {
		
		return productService.addProduct(product);
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		
		return productService.getProductById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}

}
