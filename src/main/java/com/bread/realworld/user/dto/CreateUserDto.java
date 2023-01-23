package com.bread.realworld.user.dto;

import com.bread.realworld.user.dto.CommonUserResponseDto.UserResponseDto;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author bread
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateUserDto {

  private String username;
  @NotEmpty
  private String email;
  private String password;
}
