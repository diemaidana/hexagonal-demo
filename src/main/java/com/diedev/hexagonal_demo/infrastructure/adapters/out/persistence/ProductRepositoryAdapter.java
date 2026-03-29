package com.diedev.hexagonal_demo.infrastructure.adapters.out.persistence;

import com.diedev.hexagonal_demo.application.ports.out.ProductRepository;
import com.diedev.hexagonal_demo.domain.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductRepositoryJpa productRepositoryJpa;

    public ProductRepositoryAdapter(ProductRepositoryJpa productRepositoryJpa) {
        this.productRepositoryJpa = productRepositoryJpa;
    }

    @Override
    public Product saveProduct(Product product) {
        ProductEntity saved = productRepositoryJpa.save(toEntity(product));
        return toDomain(saved);
    }

    @Override
    public Optional<Product> getProductById(UUID id) {
        return productRepositoryJpa.findById(id).map(this::toDomain);
    }

    private Product toDomain(ProductEntity saved) {
        return new Product(
                saved.getId(),
                saved.getName(),
                saved.getPrice(),
                saved.getProductStatus()
        );
    }

    private ProductEntity toEntity(Product product) {
        return new ProductEntity(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStatus()
        );
    }
}
