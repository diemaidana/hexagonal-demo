package com.diedev.hexagonal_demo.infrastructure.config;

import com.diedev.hexagonal_demo.application.ports.out.ProductRepository;
import com.diedev.hexagonal_demo.application.usecases.ProductService;
import com.diedev.hexagonal_demo.infrastructure.adapters.out.persistence.ProductRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ProductService getProductService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }
}
