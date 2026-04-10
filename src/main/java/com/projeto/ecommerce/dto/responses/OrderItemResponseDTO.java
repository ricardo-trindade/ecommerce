package com.projeto.ecommerce.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponseDTO {
    private UUID productId;
    private String productName;
    private Integer quantity;
    private Double price;

}
