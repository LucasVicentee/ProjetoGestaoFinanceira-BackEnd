package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class StratUp {

	public static void main(String[] args) {
		SpringApplication.run(StratUp.class, args);
	}

}
