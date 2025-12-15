package com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.controller.user;


import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.user.JwtResponse;
import com.LucasVicentee.ProjetoGestaoFinanceira_BackEnd.dto.user.LoginRequest;
import org.apache.coyote.Response;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        String jtw = jtwUtil.generateToken(authentication);
        return ResponseEntity.ok(new JwtResponse());
    }
}
