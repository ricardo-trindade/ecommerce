package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.enums.StatusDoPedido;
import com.projeto.ecommerce.requests.OrderRequestDTO;
import com.projeto.ecommerce.requests.UserRequestDTO;
import com.projeto.ecommerce.responses.OrderResponseDTO;
import com.projeto.ecommerce.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // criar pedido
    @PostMapping("/create")
    public ResponseEntity<OrderResponseDTO> createOrder(@Valid @RequestBody OrderRequestDTO orderReq) {
        OrderResponseDTO orderRes = orderService.createOrder(orderReq);
        return ResponseEntity.ok(orderRes);
    }

    // Mostrar pedido por ID
    @GetMapping("/show/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable UUID id) {
        OrderResponseDTO orderRes = orderService.getOrderById(id);
        return ResponseEntity.ok(orderRes);
    }

    // Atualizar status do pedido
    @PutMapping("/update/{id}")
    public ResponseEntity<OrderResponseDTO> updateOrderStatus(@PathVariable UUID id,
                                                              @RequestBody Map<String, String> body) {
        StatusDoPedido status = StatusDoPedido.valueOf(body.get("status"));
        OrderResponseDTO orderRes = orderService.updateOrderStatus(id, status);
        return ResponseEntity.ok(orderRes);
    }

    // Deletar pedido
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable UUID id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.ok("usuário deletado com sucesso!");
    }
}
