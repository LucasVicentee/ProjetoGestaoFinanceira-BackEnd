package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.controller;

import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.UserCreateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.UserResponseDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.mapper.UserMapper;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    private UserMapper mapper;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDTO create(@RequestBody UserCreateDTO dto) {
        return service.create(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
