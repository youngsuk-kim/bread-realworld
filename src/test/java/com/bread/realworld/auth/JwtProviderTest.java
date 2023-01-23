package com.bread.realworld.auth;

import org.junit.jupiter.api.Test;

import static com.bread.realworld.Constants.testEmail;
import static com.bread.realworld.Constants.testSecretKey;
import static com.bread.realworld.Constants.validityInMilliseconds;
import static org.assertj.core.api.Assertions.assertThat;

public class JwtProviderTest {

  @Test
  void create() {
    String jwt = new JwtProvider(testSecretKey, validityInMilliseconds)
        .create(testEmail);

    assertThat(JwtVerifier.execute(new JwtVerifierDto(jwt, testSecretKey, testEmail)))
        .isTrue();
  }
}
