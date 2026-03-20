package com.projeto.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private String imgURL;

    public ProductEntity(String name, String description, Double price, String imgURL) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgURL = imgURL;

    }

//    Relacionamentos
//    Produto -> categoria
    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<CategoryEntity> categories = new HashSet<>();
    //    Pedidos -> item do pedido
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItemEntity> items = new HashSet<>();
    public Set<OrderItemEntity> getItems(){
        return items;
    }
    public List<OrderEntity> getOrder(){
        return items.stream().map(x -> x.getOrder()).toList();
    }
 }
