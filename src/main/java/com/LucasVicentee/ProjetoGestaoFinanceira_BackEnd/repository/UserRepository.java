package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.repository;

import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
