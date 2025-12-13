package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.service;

import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.UserCreateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.UserResponseDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.exceptions.user.ResourceNotFoundException;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.mapper.UserMapper;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.User;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {

    @Autowired
    UserMapper mapper;

    private Logger logger =Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponseDTO create(UserCreateDTO dto) {
        logger.info("Creating a new User!");

        User user = mapper.toEntity(dto);

        user.setPassword(passwordEncoder.encode(user.getPassword())); // Pega a senha passada "crua" pelo usuário e codifica

        User saved = repository.save(user); // Salva no repositório

        return mapper.toDTO(saved); // Retorna a entidade convertida em DTO (sem senha)
    }

    public boolean checkPassword(String rawPassWord, String storedHashedPassword) {
        return passwordEncoder.matches(rawPassWord, storedHashedPassword); // Verifica se a senha que o usuário digitar é igual ao do armazenado no banco em Hash no momento do Login
    }

    public void delete(Long id) {
        logger.info("Deleting a User!");

        User entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID Not Found!"));
        repository.delete(entity);
    }
}
