package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.repository.expense;

import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.expense.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUserId(Long userId);
}
