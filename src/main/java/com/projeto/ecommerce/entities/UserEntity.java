package com.projeto.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.projeto.ecommerce.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {
    //  Chave primária
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private String password;
    //  Salvar no banco com as informações do Enum e não com zero, 1, 2...
    @Enumerated(EnumType.STRING)
//  vai servir pra gerenciar as permissões do usuário
    private RoleEnum roles;
    //  Anotation pra falar que é uma relaçao 1 para muitos baseado na chave estrangeira client
    @OneToMany(mappedBy = "client")
//  Criando uma lista pra mostrar todos os pedidos dos Usuários
    @JsonIgnore
    private List<OrderEntity> orders = new ArrayList<>();

    public UserEntity(String name, String email, String phone, String password, RoleEnum roles) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.roles = roles;
    }
}
