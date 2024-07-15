package com.esteban.forohub.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.esteban.forohub.model.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256("123456");
            return JWT.create()
                    .withIssuer("forohub")
                    .withSubject(user.getUsername())
                    .withExpiresAt(generarFechaExperacion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error al generar el token");
        }
    }
    public String getSubject(String token){
        if(token == null || token.isEmpty()){
            throw new RuntimeException();
        }
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("123456");
            verifier = JWT.require(algorithm)
                    // specify any specific claim validations
                    .withIssuer("forohub")
                    // reusable verifier instance
                    .build().verify(token);


        } catch (JWTVerificationException exception){
            throw new RuntimeException("Error al verificar el token");
        }
        if(verifier.getSubject() == null){
            throw new RuntimeException("Error al verificar el token");
        }
        return verifier.getSubject();
    }
    private Instant generarFechaExperacion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
