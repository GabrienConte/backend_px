package br.ufsm.backend_px.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenServiceJWT {
    // org.springframework.security.core.userdetails.User;
    public String gerarToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256("POO2");
            System.out.println(user.getAuthorities().stream().toList().get(0).toString());
            return JWT.create()
                    .withIssuer("API Px")
                    .withSubject(user.getUsername())
                    .withClaim("permissao", user.getAuthorities().stream().toList().get(0).toString())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        }catch (JWTCreationException e){
            throw new RuntimeException("Eror ao gerar o token JWT", e);
        }
    }
    private Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
    public String getSubject(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256("POO2");
            return JWT.require(algorithm)
                    .withIssuer("API Px")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException e){
            throw new RuntimeException("Token inválido ou expirado");
        }
    }
}

