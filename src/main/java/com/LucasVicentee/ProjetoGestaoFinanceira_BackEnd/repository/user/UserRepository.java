package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.repository.user;

import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
