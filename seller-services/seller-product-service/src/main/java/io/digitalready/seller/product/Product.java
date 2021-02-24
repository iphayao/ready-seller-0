package io.digitalready.seller.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String unit;
}
