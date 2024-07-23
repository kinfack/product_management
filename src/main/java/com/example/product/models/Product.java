package com.example.product.models;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Product ID", example = "1")
    private Long id;

    @Schema(description = "Product code", example = "P001")
    private String code;

    @Schema(description = "Product name", example = "Product 1")
    private String name;

    @Schema(description = "Product description", example = "Product 1 description")
    private String description;

    @Schema(description = "Product price", example = "100.00")
    private BigDecimal price;

    @Schema(description = "Product quantity", example = "10")
    private Integer quantity;

    @Schema(description = "Product inventory status", example = "In Stock")
    private String inventoryStatus;

    @Schema(description = "Product category", example = "Electronics")
    private String category;

    @Schema(description = "Product rating", example = "4.5")
    private Double rating;

    @Schema(description = "Product image", example = "product1.jpg")
    private String image;

}
