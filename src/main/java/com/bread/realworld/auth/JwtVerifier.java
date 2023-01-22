package com.bread.realworld.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

/**
 * @author bread
 */
public class JwtVerifier {

    private JwtVerifier() {}

    public static boolean execute(JwtVerifierDto jwtVerifierDto) {
        final SecretKey key = Keys.hmacShaKeyFor(jwtVerifierDto.getSecretKey().getBytes(StandardCharsets.UTF_8));

        final Claims body = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwtVerifierDto.getJws())
                .getBody();

        return body.getId().equals(jwtVerifierDto.getUserId());
    }
}
