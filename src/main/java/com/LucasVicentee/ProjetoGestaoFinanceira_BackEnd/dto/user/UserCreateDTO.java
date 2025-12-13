package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class UserCreateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "First name cannot be null")
    @Size(max = 150)
    private String firstName;

    @NotBlank(message = "Last name cannot be null")
    @Size(max = 150)
    private String lastName;

    @NotBlank(message = "This E-mail cannot be invalid")
    @Email(message = "This E-mail is not valid!")
    private String email;

    @NotBlank(message = "This password does not match the rules")
    @Size(min = 6, max = 30, message = "The password needs contains min 6 character and max 30 characters!")
    private String password;

    @NotNull(message = "The big decimal cannot be null (Exception in Register or Login")
    private BigDecimal monthlyIncome;

    @NotNull(message = "The current balance cannot be null (Exception in Register or Login)")
    private BigDecimal currentBalance;
}
