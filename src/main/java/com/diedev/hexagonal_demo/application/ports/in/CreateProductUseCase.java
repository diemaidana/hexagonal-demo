package com.diedev.hexagonal_demo.application.ports.in;

import com.diedev.hexagonal_demo.domain.model.Product;

import java.math.BigDecimal;

public interface CreateProductUseCase {
    Product createProduct(String name, BigDecimal price);
}
