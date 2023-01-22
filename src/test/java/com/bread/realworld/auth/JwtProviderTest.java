package com.bread.realworld.auth;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JwtProviderTest {
    @Test
    void create() {
        final String testSecretKey = "testSecretKeyValueTestSecretKeyValue";
        final String testUserId = "testId";
        final long validityInMilliseconds = 100000;

        String jwt = new JwtProvider(testSecretKey, validityInMilliseconds)
                .create(testUserId);

        assertThat(JwtVerifier.execute(new JwtVerifierDto(jwt, testSecretKey, testUserId)))
                .isTrue();
    }
}
