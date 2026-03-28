package com.diedev.hexagonal_demo.infrastructure.adapters.in.web;

import com.diedev.hexagonal_demo.application.ports.in.ActivateProductUseCase;
import com.diedev.hexagonal_demo.application.ports.in.CreateProductUseCase;
import com.diedev.hexagonal_demo.application.ports.in.GetProductUseCase;
import com.diedev.hexagonal_demo.domain.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final CreateProductUseCase createProductUseCase;
    private final ActivateProductUseCase activateProductUseCase;
    private final GetProductUseCase getProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase,
                             ActivateProductUseCase activateProductUseCase,
                             GetProductUseCase getProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.activateProductUseCase = activateProductUseCase;
        this.getProductUseCase = getProductUseCase;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest request) {
        Product product = createProductUseCase.createProduct(request.name(), request.price());
        return ResponseEntity.status(201).body(ProductResponse.createProductResponse(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable UUID id){
        Product product = getProductUseCase.getProduct(id);
        return ResponseEntity.status(200).body(ProductResponse.createProductResponse(product));
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<ProductResponse> activateProduct(@PathVariable UUID id){
        Product product = activateProductUseCase.activateProduct(id);
        return ResponseEntity.status(200).body(ProductResponse.createProductResponse(product));
    }
}
