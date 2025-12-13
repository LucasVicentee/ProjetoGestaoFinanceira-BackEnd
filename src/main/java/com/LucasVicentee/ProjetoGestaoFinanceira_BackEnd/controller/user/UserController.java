package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.controller.user;

import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.user.UserCreateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.user.UserResponseDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.user.UserUpdateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.mapper.user.UserMapper;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.service.user.UserService;
import jakarta.validation.Valid;
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
    UserMapper mapper;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDTO create(@Valid @RequestBody UserCreateDTO dto) {
        return service.create(dto);
    }

    @PatchMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDTO updatePartially(@PathVariable("id") Long id, @RequestBody UserUpdateDTO dto) {
        return service.updatePartially(id, dto);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
