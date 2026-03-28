package com.diedev.hexagonal_demo.infrastructure.adapters.in.web;

import java.math.BigDecimal;

public record CreateProductRequest(String name, BigDecimal price) {
}
