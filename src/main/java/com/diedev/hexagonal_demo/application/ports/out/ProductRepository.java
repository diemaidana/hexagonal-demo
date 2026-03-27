package com.diedev.hexagonal_demo.application.ports.out;

import com.diedev.hexagonal_demo.domain.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    Product saveProduct(Product product);
    Optional<Product> getProductById(UUID id);
}
