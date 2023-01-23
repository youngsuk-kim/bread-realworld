package com.bread.realworld.user;

import com.bread.realworld.auth.JwtProvider;
import com.bread.realworld.user.dto.CreateUserDto;
import com.bread.realworld.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author bread
 */
@Service
@RequiredArgsConstructor
public class UserService {

  private final JwtProvider jwtProvider;
  private final UserRepository userRepository;

  public User createUser(CreateUserDto createUserDto) {
    String token = jwtProvider.create(createUserDto.getEmail());

    User user = User.builder()
        .username(createUserDto.getUsername())
        .email(createUserDto.getEmail())
        .token(token)
        .build();
    userRepository.save(user);

    return user;
  }
}
