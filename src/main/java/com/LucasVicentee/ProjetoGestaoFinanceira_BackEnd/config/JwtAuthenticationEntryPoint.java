package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint { // Essa classe cria mensagem de erro personalizada para o usuário no momento da autenticação

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // HTTP 401

        response.setContentType(MediaType.APPLICATION_JSON_VALUE); // Tipo de conteúdo como JSON

        final String message = "Falha na autenticação. Usuário ou senha incorretos."; // Mensagem personalizada para o usuário

        final ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(response.getOutputStream(), Collections.singletonMap("error", message));
    }
}
