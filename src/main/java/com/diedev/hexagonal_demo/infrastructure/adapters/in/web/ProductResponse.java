package com.diedev.hexagonal_demo.infrastructure.adapters.in.web;

import com.diedev.hexagonal_demo.domain.model.Product;
import com.diedev.hexagonal_demo.domain.model.ProductStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(UUID id, String name, BigDecimal price, ProductStatus productStatus) {
    public static ProductResponse createProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStatus()
        );
    }
}
