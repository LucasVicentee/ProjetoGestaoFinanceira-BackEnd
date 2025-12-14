package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.expense;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseCreateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "The title cannot be null")
    @Size(max = 50)
    private String expenseTitle;

    @NotNull(message = "The value of expense cannot be null")
    private BigDecimal expenseValue;

    @NotBlank(message = "The title cannot be null")
    @Size(max = 500)
    private String expenseDescription;
}
