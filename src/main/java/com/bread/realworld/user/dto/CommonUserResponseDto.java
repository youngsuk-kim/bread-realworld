package com.bread.realworld.user.dto;

import com.bread.realworld.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author bread
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommonUserResponseDto {
  private String email;
  private String token;
  private String username;
  private String bio;
  private String image;

  @AllArgsConstructor
  @Getter
  public static class UserResponseDto {
    private CommonUserResponseDto user;

    public static UserResponseDto toUserResponse(User user) {
      return new UserResponseDto(
          new CommonUserResponseDto(
              user.getEmail(),
              user.getToken(),
              user.getUsername(),
              user.getBio(),
              user.getImage()
          )
      );
    }
  }
}
