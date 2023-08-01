package com.project.dealer_api.controller;

import com.project.dealer_api.domain.user.DataAuth;
import com.project.dealer_api.infra.security.DataTokeJWT;
import com.project.dealer_api.infra.security.TokenService;
import com.project.dealer_api.domain.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid DataAuth dataAuth) {
        var token = new UsernamePasswordAuthenticationToken(dataAuth.login(), dataAuth.password());
        var authentication = authenticationManager.authenticate(token);


        String tokenJWT = tokenService.gerarToken((Users) authentication.getPrincipal());
        return ResponseEntity.ok(new DataTokeJWT(tokenJWT));
    }
}
