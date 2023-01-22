package com.bread.realworld.auth;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JwtProviderTest {
    @Test
    void create() {
        final String testSecretKey = "testSecretKeyValueTestSecretKeyValue";
        final String testUserId = "testId";
        final long validityInMilliseconds = 100000;

        String jwt = new JwtProvider(testSecretKey, validityInMilliseconds)
                .create(testUserId);

        Assertions.assertThat(JwtVerifier.execute(jwt, testSecretKey,testUserId))
                .isTrue();
    }
}
