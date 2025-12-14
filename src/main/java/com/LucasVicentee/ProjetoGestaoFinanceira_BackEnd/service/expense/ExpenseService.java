package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.service.expense;

import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.expense.ExpenseCreateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.expense.ExpenseResponseDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.expense.ExpenseUpdateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.exceptions.RequiredObjectIsNullException;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.exceptions.ResourceNotFoundException;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.mapper.expense.ExpenseMapper;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.expense.Expense;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.repository.expense.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.logging.Logger;

public class ExpenseService {

    private Logger logger = Logger.getLogger(ExpenseService.class.getName());

    @Autowired
    private ExpenseMapper mapper;

    @Autowired
    private ExpenseRepository repository;

    @Autowired
    private ExpenseService service;

    public ExpenseResponseDTO create(ExpenseCreateDTO expense) {
        if (expense == null) throw new RequiredObjectIsNullException();
        logger.info("Creating a expense!");

        Expense entity = mapper.toEntity(expense);
        Expense savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    public ExpenseResponseDTO updatePartially(Long id, ExpenseUpdateDTO expense) {
        if (expense == null) throw new ResourceAccessException("The request body cannot be null");
        logger.info("Updating partially user with ID: " + expense.getId());

        Expense entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Records not found here!"));

        if (expense.getExpenseTitle() != null) {
            entity.setExpenseTitle(expense.getExpenseTitle());
        }

        if (expense.getExpenseValue() != null) {
            entity.setExpenseValue(expense.getExpenseValue());
        }

        if (expense.getExpenseDescription() != null) {
            entity.setExpenseDescription(expense.getExpenseDescription());
        }

        return mapper.toDTO(entity);
    }

    public List<ExpenseResponseDTO> findAllByUser(Long userId) {
        logger.info("Finding all expenses!");

        List<Expense> expenses = repository.findByUserId(userId);
        return mapper.toListDTO(expenses);
    }

    public void delete(Long id) {
        logger.info("Deleting a Expense!");

        Expense entity = repository.findById(id).orElseThrow(() -> new ResourceAccessException("ID expense not found!"));
        repository.delete(entity);
    }
}
