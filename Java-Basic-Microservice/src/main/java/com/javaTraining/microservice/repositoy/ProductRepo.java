package com.javaTraining.microservice.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaTraining.microservice.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
