package com.javatraining.microservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.javatraining.microservice.entity.Product;
import com.javatraining.microservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    // Test for getAllProduct()
    @Test
    void testGetAllProduct() throws Exception {
        // Prepare mock data
        Product product1 = new Product(1L, "Product1", 100.0);
        Product product2 = new Product(2L, "Product2", 200.0);

        when(productService.getAll()).thenReturn(Arrays.asList(product1, product2));

        // Perform GET request and verify the response
        mockMvc.perform(get("/product/getAll")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Product1"))
                .andExpect(jsonPath("$[1].name").value("Product2"));
    }

    // Test for addProduct()
    @Test
    void testAddProduct() throws Exception {
        // Prepare mock data
        Product product = new Product(1L, "NewProduct", 150.0);

        when(productService.addProduct(any(Product.class))).thenReturn(product);

        // Perform POST request and verify the response
        mockMvc.perform(post("/product/add-product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("NewProduct"));
    }

    // Test for getProductById()
    @Test
    void testGetProductById() throws Exception {
        // Prepare mock data
        Product product = new Product(1L, "ProductById", 100.0);

        when(productService.getProductById(1L)).thenReturn(Optional.of(product));

        // Perform GET request and verify the response
        mockMvc.perform(get("/product/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("ProductById"));
    }

    // Test for deleteProduct()
    @Test
    void testDeleteProduct() throws Exception {
        // Mock service call
        doNothing().when(productService).deleteProduct(1L);

        // Perform DELETE request and verify the response
        mockMvc.perform(delete("/product/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
