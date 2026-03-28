package com.diedev.hexagonal_demo.application.usecases;

import com.diedev.hexagonal_demo.application.ports.in.ActivateProductUseCase;
import com.diedev.hexagonal_demo.application.ports.in.CreateProductUseCase;
import com.diedev.hexagonal_demo.application.ports.in.GetProductUseCase;
import com.diedev.hexagonal_demo.application.ports.out.ProductRepository;
import com.diedev.hexagonal_demo.domain.model.Product;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductService implements CreateProductUseCase, GetProductUseCase, ActivateProductUseCase {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(String name, BigDecimal price) {
        Product product = new Product(
                UUID.randomUUID(),
                name,
                price
        );

        return productRepository.saveProduct(product);
    }

    @Override
    public Product getProduct(UUID id) {
        return productRepository.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encuentra el producto."));
    }

    @Override
    public Product activateProduct(UUID id) {
        Product product = getProduct(id);
        product.activateProduct();
        return productRepository.saveProduct(product);
    }
}
