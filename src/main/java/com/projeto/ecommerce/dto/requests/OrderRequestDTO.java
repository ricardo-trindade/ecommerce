package com.projeto.ecommerce.dto.requests;

import com.projeto.ecommerce.enums.StatusDoPedido;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Getter
public class OrderRequestDTO {
    private LocalDateTime moment;
    private StatusDoPedido status;
    private UUID client;
    private UUID payment;
    private List<OrderItemRequestDTO> items;
}
