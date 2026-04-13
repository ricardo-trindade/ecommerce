package com.projeto.ecommerce.services;

import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.repositories.UserRepository;
import com.projeto.ecommerce.dto.requests.UserRequestDTO;
import com.projeto.ecommerce.dto.responses.UserResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder; // Adicionado
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // Adicionado

    // Injeção via construtor atualizada
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserResponseDTO createUser(UserRequestDTO userReq) {
        if (userReq == null) {
            throw new IllegalArgumentException("Os dados inseridos são inválidos");
        }

        if (userRepository.findByEmail(userReq.getEmail()).isPresent()) {
            throw new RuntimeException("Já existe um usuário com esse email cadastrado");
        }

        // Criptografando a senha também na criação!
        String encodedPassword = passwordEncoder.encode(userReq.getPassword());

        UserEntity newUser = new UserEntity(
                userReq.getName(),
                userReq.getEmail(),
                userReq.getPhone(),
                encodedPassword,
                userReq.getRoles()
        );

        userRepository.save(newUser);
        return new UserResponseDTO(newUser.getId(), newUser.getName(), newUser.getEmail(), newUser.getPhone());
    }

    public UserResponseDTO getUserById(UUID id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + id));

        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone());
    }

    @Transactional
    public UserResponseDTO updateUserById(UUID id, UserRequestDTO userReq) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não existe um usuário com esse id"));

        userEntity.setName(userReq.getName());
        userEntity.setEmail(userReq.getEmail());
        userEntity.setPhone(userReq.getPhone());

        // Agora o passwordEncoder está disponível
        userEntity.setPassword(passwordEncoder.encode(userReq.getPassword()));
        userEntity.setRoles(userReq.getRoles());

        userRepository.save(userEntity);
        return new UserResponseDTO(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getPhone());
    }

    @Transactional
    public void deleteUserById(UUID id){
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("Não existe um usuário com esse id");
        }
        userRepository.deleteById(id);
    }
}