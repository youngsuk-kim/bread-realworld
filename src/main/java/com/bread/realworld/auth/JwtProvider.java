package com.bread.realworld.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author bread jwt 토큰을 발급해 주는 역할을 하는 클래스
 */
@Component
public class JwtProvider {

  private final SecretKey secretKey;
  private final long validityInMilliseconds;

  public JwtProvider(
      @Value("${jwt.secret-key}") final String secretKey,
      @Value("${jwt.expire-length}") final long validityInMilliseconds
  ) {
    this.secretKey = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    this.validityInMilliseconds = validityInMilliseconds;
  }

  public String create(String userId) {
    final Date now = new Date();
    final Date validity = new Date(now.getTime() + validityInMilliseconds);

    return Jwts.builder()
        .setId(userId)
        .signWith(secretKey)
        .setExpiration(validity)
        .compact();
  }
}
