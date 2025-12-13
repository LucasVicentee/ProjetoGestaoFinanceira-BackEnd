package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class UserCreateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private BigDecimal monthlyIncome;
    private BigDecimal currentBalance;
}
