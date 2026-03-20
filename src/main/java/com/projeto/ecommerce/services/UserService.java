package com.projeto.ecommerce.services;

import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.repositories.UserRepository;
import com.projeto.ecommerce.requests.UserRequestDTO;
import com.projeto.ecommerce.responses.UserResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO userReq) {
        if (userReq == null) {
            throw new IllegalArgumentException("os dados inseridos são inválidos");
        }
        if (userRepository.findByEmail(userReq.getEmail()).isPresent()) {
            throw new DuplicateKeyException("já existe um usuário com esse email cadastrado");
        }
        UserEntity newUser = new UserEntity(userReq.getName(), userReq.getEmail(), userReq.getPhone(), userReq.getPassword(), userReq.getRoles());
        userRepository.save(newUser);
        return new UserResponseDTO(newUser.getId(),newUser.getName(), newUser.getEmail(), newUser.getPhone());
    }

    public UserResponseDTO getUserById(UUID id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + id));

        return new UserResponseDTO(user.getId(),user.getName(), user.getEmail(), user.getPhone());
    }

    public UserResponseDTO updateUserById(UUID id, UserRequestDTO userReq) {
//      metodo do Jpa repository que retorna um optional(podendo estar vazio ou com objeto)
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("não existe um usuário com esse id"));
//      atualiza o usuario com id passado
        userEntity.setName(userReq.getName());
        userEntity.setEmail(userReq.getEmail());
        userEntity.setPhone(userReq.getPhone());
        userEntity.setPassword(userReq.getPassword());
        userEntity.setRoles(userReq.getRoles());
//      salva como novo usuario
        UserEntity updatedUser = userRepository.save(userEntity);
//      retorna o response
        return new UserResponseDTO(updatedUser.getId(),updatedUser.getName(), updatedUser.getEmail(), updatedUser.getPhone());
    }
    public void deleteUserById(UUID id){
        userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("não existe um usuário com esse id"));
        userRepository.deleteById(id);
    }
}
