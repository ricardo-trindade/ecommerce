package com.projeto.ecommerce.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDTO {
    UUID id;
    private String name;
    private String description;
    private Double price;


    public ProductResponseDTO(UUID id ,String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
