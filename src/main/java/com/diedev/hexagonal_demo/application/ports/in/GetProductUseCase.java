package com.diedev.hexagonal_demo.application.ports.in;

import com.diedev.hexagonal_demo.domain.model.Product;

import java.util.UUID;

public interface GetProductUseCase {
    Product getProduct(UUID id);
}
