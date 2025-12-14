package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.mapper.expense;

import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.expense.ExpenseCreateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.expense.ExpenseResponseDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.expense.Expense;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {


    Expense toEntity(ExpenseCreateDTO dto);

    ExpenseResponseDTO toDTO(Expense expense);
}
