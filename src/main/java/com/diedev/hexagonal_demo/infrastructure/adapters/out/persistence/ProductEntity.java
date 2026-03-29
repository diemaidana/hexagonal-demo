package com.diedev.hexagonal_demo.infrastructure.adapters.out.persistence;

import com.diedev.hexagonal_demo.domain.model.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductEntity {
    @Id
    private UUID id;

    private String name;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;
}
