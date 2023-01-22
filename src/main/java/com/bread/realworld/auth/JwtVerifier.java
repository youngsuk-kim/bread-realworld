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

    public static boolean execute(String jws, String secretKey, String userId) {
        final SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        final Claims body = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jws)
                .getBody();

        return body.getId().equals(userId);
    }
}
