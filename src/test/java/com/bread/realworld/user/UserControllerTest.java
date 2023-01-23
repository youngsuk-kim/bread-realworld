package com.bread.realworld.user;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.bread.realworld.user.dto.CreateUserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void createUser() throws Exception {
    mockMvc.perform(
        MockMvcRequestBuilders
            .post("/api/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(new CreateUserDto("testUserName", "testEmail", "testPassword"))))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.user.username").value("testUserName"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.user.email").value("testEmail"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.user.token").value("testToken"));
  }

  @Test
  void createUserEmptyEmail() throws Exception {
    mockMvc.perform(
            MockMvcRequestBuilders
                .post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new CreateUserDto("userName", "", "testPassword"))))
        .andDo(print())
        .andExpect(status().is4xxClientError());
  }
}
