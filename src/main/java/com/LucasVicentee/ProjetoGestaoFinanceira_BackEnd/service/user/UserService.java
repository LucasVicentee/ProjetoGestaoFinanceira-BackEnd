package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.service.user;

import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.user.UserCreateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.user.UserResponseDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.user.UserUpdateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.exceptions.RequiredObjectIsNullException;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.exceptions.ResourceNotFoundException;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.mapper.user.UserMapper;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.user.User;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {

    private Logger logger =Logger.getLogger(UserService.class.getName());

    @Autowired
    UserMapper mapper;

    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserResponseDTO create(UserCreateDTO user) {

        if (user == null) throw new RequiredObjectIsNullException();
        logger.info("Creating a new User!");

        User entity = mapper.toEntity(user);
        entity.setPassword(passwordEncoder.encode(entity.getPassword())); // Pega a senha passada "crua" pelo usuário e codifica
        User savedEntity = repository.save(entity); // Salva no repositório
        return mapper.toDTO(savedEntity); // Retorna a entidade convertida em DTO (sem senha)
    }

    public boolean checkPassword(String rawPassWord, String storedHashedPassword) {
        return passwordEncoder.matches(rawPassWord, storedHashedPassword); // Verifica se a senha que o usuário digitar é igual ao do armazenado no banco em Hash no momento do Login
    }

    public UserResponseDTO updatePartially(Long id, UserUpdateDTO user) {

        if (user == null) {
            throw new RequiredObjectIsNullException("The request body cannot be null");
        }

        logger.info("Updating partially user with ID: " + user.getId());

        User entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Records not found here!"));

        if (user.getFirstName() != null) {
            entity.setFirstName(user.getFirstName());
        }

        if (user.getLastName() != null) {
            entity.setLastName(user.getLastName());
        }

        if (user.getPassword() != null) {
            entity.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        if (user.getMonthlyIncome() != null) {
            entity.setMonthlyIncome(user.getMonthlyIncome());
        }

        User updatedEntity = repository.save(entity);

        return mapper.toDTO(updatedEntity);
    }

    public void delete(Long id) {
        logger.info("Deleting a User!");

        User entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID Not Found!"));
        repository.delete(entity);
    }
}
