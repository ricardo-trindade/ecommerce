package com.projeto.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.projeto.ecommerce.enums.StatusDoPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDateTime moment;
    private StatusDoPedido status;

    public void setClient(UserEntity client) {
        this.client = client;
    }

    //  Anotation pra falar que é uma relação de muitos pra 1
    @ManyToOne
//  define qual coluna será usada como chave estrangeira na tabela
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private UserEntity client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private PaymentEntity payment;

    @OneToMany(mappedBy = "id.order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItemEntity> items = new HashSet<>();

    public Set<OrderItemEntity> getItems() {
        return items;
    }

    public List<ProductEntity> getProduct() {
        return items.stream().map(x -> x.getProduct()).toList();
    }
}
