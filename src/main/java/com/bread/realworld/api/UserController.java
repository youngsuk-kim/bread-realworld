package com.bread.realworld.api;

import com.bread.realworld.user.UserService;
import com.bread.realworld.user.dto.CommonUserResponseDto.UserResponseDto;
import com.bread.realworld.user.dto.CreateUserDto;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bread
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  @ResponseBody
  public UserResponseDto createUser(
      @RequestBody @Valid
      CreateUserDto createUserDto
  ) {
    return UserResponseDto.toUserResponse(userService.createUser(createUserDto));
  }
}
