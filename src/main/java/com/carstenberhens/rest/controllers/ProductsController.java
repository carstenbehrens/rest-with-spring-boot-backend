package com.carstenberhens.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {
    ProductsController() {

    }

    @GetMapping("/test")
    private String testing() {
        return "Works fine...";
    }
}
