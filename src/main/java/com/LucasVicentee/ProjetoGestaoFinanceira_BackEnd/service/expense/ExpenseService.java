package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.service.expense;

import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.expense.ExpenseCreateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.expense.ExpenseResponseDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.expense.ExpenseUpdateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.exceptions.RequiredObjectIsNullException;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.exceptions.ResourceNotFoundException;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.mapper.expense.ExpenseMapper;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.expense.Expense;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.user.User;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.repository.expense.ExpenseRepository;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ExpenseService {

    private Logger logger = Logger.getLogger(ExpenseService.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenseMapper mapper;

    @Autowired
    private ExpenseRepository repository;

    public ExpenseResponseDTO create(Long userId, ExpenseCreateDTO expense) {
        if (expense == null) throw new RequiredObjectIsNullException();
        logger.info("Creating a expense!");

        User userEntity = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(""));

        Expense entity = mapper.toEntity(expense);
        entity.setUser(userEntity);
        Expense savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    public ExpenseResponseDTO updatePartially(Long id, ExpenseUpdateDTO expense) {
        if (expense == null) throw new ResourceAccessException("The request body cannot be null");
        logger.info("Updating partially user with ID: " + id);

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

        Expense updatedEntity = repository.save(entity);
        return mapper.toDTO(updatedEntity);
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
