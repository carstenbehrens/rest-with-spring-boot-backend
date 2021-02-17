package com.carstenberhens.rest.controllers;

import com.carstenberhens.rest.models.Product;
import com.carstenberhens.rest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    public static String URI = "/api/products/";

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    private Product create(@RequestBody Product product) {
        try {
            return productService.create(product);
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error, Please check if you have provided the correct data");
        }
    }

    @GetMapping("/")
    private List<Product> findAll() {
        try {
            return productService.findAll();
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    @GetMapping("/{id}")
    private Product findById(@PathVariable("id") Long id) {
        try {
            return productService.findById(id);
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }

    @PutMapping("/")
    private Product update(@RequestBody Product product) {
        try {
            return productService.update(product);
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }

    @DeleteMapping("/")
    private void deleteAll() {
        try {
            productService.deleteAll();
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable("id") Long id) {
        try {
            productService.deleteById(id);
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }
}
