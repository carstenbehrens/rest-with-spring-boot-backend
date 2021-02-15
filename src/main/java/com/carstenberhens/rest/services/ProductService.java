package com.carstenberhens.rest.services;

import com.carstenberhens.rest.models.Product;
import com.carstenberhens.rest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public Product create(Product product) {
        return repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return  repository.findById(id).orElseThrow();
    }

    public Product update(Product product) {
        Product entity = repository.findById(product.getId()).orElseThrow();

        entity.setTitle(product.getTitle());
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        return repository.save(entity);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(Long id) {
        Product entity = repository.findById(id).orElseThrow();
        repository.delete(entity);
    }

}
