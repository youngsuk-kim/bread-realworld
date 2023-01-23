package com.bread.realworld.user;

import static com.bread.realworld.Constants.testSecretKey;
import static com.bread.realworld.Constants.validityInMilliseconds;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.bread.realworld.auth.JwtProvider;
import com.bread.realworld.auth.JwtVerifier;
import com.bread.realworld.auth.JwtVerifierDto;
import com.bread.realworld.user.dto.CreateUserDto;
import com.bread.realworld.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
  @Mock
  private UserRepository userRepository;

  @Mock
  private JwtProvider jwtProvider;

  @InjectMocks
  private UserService userService;

  @Test
  void createUser() {
    when(jwtProvider.create(any())).thenReturn("testGeneratedToken");

    User user = userService.createUser(
        new CreateUserDto("testUsername", "testEmail", "testPassword"));


    Assertions.assertThat(user.getUsername()).isEqualTo("testUsername");
    Assertions.assertThat(user.getEmail()).isEqualTo("testEmail");
    Assertions.assertThat(user.getToken()).isEqualTo("testGeneratedToken");
  }
}
