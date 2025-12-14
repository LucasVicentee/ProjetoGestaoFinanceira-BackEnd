package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.controller.expense;


import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.expense.ExpenseCreateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.expense.ExpenseResponseDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.expense.ExpenseUpdateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.mapper.expense.ExpenseMapper;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.expense.Expense;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.service.expense.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseMapper mapper;

    @Autowired
    private ExpenseService service;

    @PostMapping(value = "/user/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ExpenseResponseDTO create(@PathVariable("userId") Long userId, @RequestBody ExpenseCreateDTO dto) {
        return service.create(userId, dto);
    }

    public List<ExpenseResponseDTO> findAllByUser(@PathVariable("userId") Long userId) {
        return service.findAllByUser(userId);
    }

    @PatchMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ExpenseResponseDTO updatePartially(@PathVariable("id") Long id, @RequestBody ExpenseUpdateDTO dto) {
        return service.updatePartially(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
