package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.controller.user;

import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.user.UserCreateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.user.UserResponseDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.user.UserUpdateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.mapper.user.UserMapper;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.user.User;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    UserMapper mapper;

    /*
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDTO register(@Valid @RequestBody UserCreateDTO dto) {
        return service.create(dto);
    }
    */

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDTO updatePartially(@AuthenticationPrincipal User loggedInUser, @PathVariable("id") Long id, @RequestBody UserUpdateDTO dto) {
        return service.updatePartially(id, loggedInUser.getId(), dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@AuthenticationPrincipal User loggedInUser, @PathVariable("id") Long id) {
        service.delete(id, loggedInUser.getId());
        return ResponseEntity.noContent().build();
    }
}
