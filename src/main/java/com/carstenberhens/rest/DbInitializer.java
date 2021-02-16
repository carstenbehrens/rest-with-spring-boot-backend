package com.carstenberhens.rest;

import com.carstenberhens.rest.models.Product;
import com.carstenberhens.rest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public DbInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        Product product1 = new Product("Konsole", "Playstation 5", "Die PlayStation ist eine Spielkonsole des japanischen Konzerns Sony");
        Product product2 = new Product("Konsole", "Nintendo Switch", "Die Nintendo Switch ist eine Spielkonsole des japanischen Herstellers Nintendo.");

        this.productRepository.save(product1);
        this.productRepository.save(product2);
    }
}
