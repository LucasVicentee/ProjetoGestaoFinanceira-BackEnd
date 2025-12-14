package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.expense;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExpenseResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String expenseTitle;
    private BigDecimal expenseValue;
    private String expenseDescription;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime expenseCreatedAt;
}
