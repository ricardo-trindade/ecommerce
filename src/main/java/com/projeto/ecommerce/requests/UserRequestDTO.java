package com.projeto.ecommerce.requests;

import com.projeto.ecommerce.enums.RoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @Size(max = 11)
    private String phone;
    @NotBlank
    private String password;
    private RoleEnum roles;
}
