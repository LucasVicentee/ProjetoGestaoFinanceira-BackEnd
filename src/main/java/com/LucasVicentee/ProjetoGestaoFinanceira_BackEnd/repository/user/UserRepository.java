package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.repository.user;

import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
