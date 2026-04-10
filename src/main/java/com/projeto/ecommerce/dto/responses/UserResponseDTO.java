package com.projeto.ecommerce.dto.responses;

import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.entities.enums.Roles;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Getter
@NoArgsConstructor
public class UserResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private Roles role;

    public UserResponseDTO(UUID id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public UserResponseDTO(UserEntity client) {
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        this.phone = client.getPhone();
    }
}
