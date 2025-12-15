package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.service.security.user;

import lombok.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration.ms}")
    private long jwtExpirationMs;

    private Key getSigninKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();

        return Jwts.builder()
                // Assunto (Subject): O nome de usuário/email
                .setSubject(userPrincipal.getUsername())
                // Data de Emissão
                .setIssuedAt(new Date())
                // Data de Expiração
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                // Tipo de Algoritmo e Chave Secreta
                .signWith(getSigningKey(), SignatureAlgorithm.HS512)
                .compact();
    }
}
