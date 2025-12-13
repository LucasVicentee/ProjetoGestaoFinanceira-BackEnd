package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private BigDecimal monthlyIncome;
}
