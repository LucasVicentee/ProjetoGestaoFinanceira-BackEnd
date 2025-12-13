package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.mapper.user;

import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.user.UserCreateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.user.UserResponseDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "monthlyIncome", ignore = true) // Ignore para manter o default na Entidade
    @Mapping(target = "currentBalance", ignore = true)  // Ignore para manter o default na Entidade
    @Mapping(target = "createdAt", ignore = true) // Campo gerenciado pelo JPA
    User toEntity(UserCreateDTO dto);

    UserResponseDTO toDTO(User user);
}
