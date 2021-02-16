package com.carstenberhens.rest.controllers;

import com.carstenberhens.rest.models.Product;
import com.carstenberhens.rest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return productService.create(product);
    }

    @GetMapping("/")
    private List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    private Product findById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @PutMapping("/")
    private Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/")
    private void deleteAll() {
        productService.deleteAll();
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable("id") Long id) {
        productService.deleteById(id);
    }
}
