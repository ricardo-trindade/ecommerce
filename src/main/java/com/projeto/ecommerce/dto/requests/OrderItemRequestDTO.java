package com.projeto.ecommerce.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequestDTO {
    private UUID productId;
    private Integer quantity;
}
