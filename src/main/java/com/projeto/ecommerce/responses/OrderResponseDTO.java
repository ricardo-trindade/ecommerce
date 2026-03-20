package com.projeto.ecommerce.responses;

import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.enums.StatusDoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderResponseDTO {
    private UUID id;
    private UserResponseDTO client;
    private LocalDateTime moment;
    private StatusDoPedido status;
    private List<OrderItemResponseDTO> items;


    public OrderResponseDTO(UUID id,UserResponseDTO client, LocalDateTime moment, StatusDoPedido status) {
        this.id = id;
        this.client = client;
        this.moment = moment;
        this.status = status;
    }
}
