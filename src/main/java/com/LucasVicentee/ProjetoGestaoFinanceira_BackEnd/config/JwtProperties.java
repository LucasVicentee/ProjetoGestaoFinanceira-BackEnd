package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private String secret;
    private Expiration expiration = new Expiration();

    public static class Expiration {
        private Long ms;

        public Long getMs() {
            return ms;
        }

        public void setMs(Long ms) {
            this.ms = ms;
        }
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Expiration getExpiration() {
        return expiration;
    }

    public void setExpiration(Expiration expiration) {
        this.expiration = expiration;
    }
}
