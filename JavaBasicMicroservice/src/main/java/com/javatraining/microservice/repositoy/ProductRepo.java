package com.javatraining.microservice.repositoy;

import com.javatraining.microservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepo extends JpaRepository<Product, Long> {

}
