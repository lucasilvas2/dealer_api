package com.project.dealer_api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.project.dealer_api.domain.user.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private static final String ISSUER = "API Dealer";

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Users user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(user.getLogin())
                    .withClaim("id", user.getId())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);

        } catch (JWTCreationException exception){
            // Invalid Signing configuration / Couldn't convert Claims.
            throw  new RuntimeException("Error ao gerar token jwt", exception);
        }
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String getSubject(String tokenJWT){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    // specify an specific claim validations
                    .withIssuer(ISSUER)
                    // reusable verifier instance
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception){
            // Invalid signature/claims
            throw  new RuntimeException("Token JWT inválido ou expirado: " + tokenJWT);
        }
    }
}
