package com.bread.realworld.auth;

/**
 * @author bread
 */
public class JwtVerifierDto {

  private final String jws;
  private final String secretKey;
  private final String userId;

  public JwtVerifierDto(String jws, String secretKey, String userId) {
    this.jws = jws;
    this.secretKey = secretKey;
    this.userId = userId;
  }

  public String getJws() {
    return jws;
  }

  public String getSecretKey() {
    return secretKey;
  }

  public String getUserId() {
    return userId;
  }
}
