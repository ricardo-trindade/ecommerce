package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.requests.UserRequestDTO;
import com.projeto.ecommerce.responses.UserResponseDTO;
import com.projeto.ecommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("create")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userReq){
        UserResponseDTO userRes = userService.createUser(userReq);
        return ResponseEntity.ok(userRes);
    }
    @GetMapping("/show/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable UUID id) {
        UserResponseDTO response = userService.getUserById(id);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity <UserResponseDTO> updateUserById(@PathVariable UUID id, @RequestBody UserRequestDTO userReq){
        UserResponseDTO updatedUser = userService.updateUserById(id, userReq);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable UUID id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("usuário deletado com sucesso!");
    }
}
