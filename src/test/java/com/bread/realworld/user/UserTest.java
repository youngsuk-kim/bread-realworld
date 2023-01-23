package com.bread.realworld.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class UserTest {

  @Test
  void create() {
    final User user = User.builder()
        .username("testUserName")
        .password("testPassword")
        .bio("testBio")
        .email("testEmail")
        .image("testImage")
        .token("testToken")
        .build();

    assertThat(user.getUsername()).isEqualTo("testUserName");
    assertThat(user.getPassword()).isEqualTo("testPassword");
    assertThat(user.getEmail()).isEqualTo("testEmail");
    assertThat(user.getBio()).isEqualTo("testBio");
    assertThat(user.getImage()).isEqualTo("testImage");
    assertThat(user.getToken()).isEqualTo("testToken");
  }
}
