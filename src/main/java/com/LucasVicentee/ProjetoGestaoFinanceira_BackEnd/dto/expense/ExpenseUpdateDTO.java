package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String expenseTitle;
    private BigDecimal expenseValue;
    private String expenseDescription;
}
