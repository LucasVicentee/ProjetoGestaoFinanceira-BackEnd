package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.mapper;

import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.UserCreateDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.UserResponseDTO;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserCreateDTO dto);
    UserResponseDTO toDTO(User user);
}
