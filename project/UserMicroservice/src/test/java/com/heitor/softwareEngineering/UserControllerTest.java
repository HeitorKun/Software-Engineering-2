package com.heitor.softwareEngineering.controllers;

import com.heitor.softwareEngineering.domain.User.User;
import com.heitor.softwareEngineering.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void getAllUsers() throws Exception {
        List<User> userList = new ArrayList<>();
        when(userService.getAllUsers()).thenReturn(userList);

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());

        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void getUserById_UserExists() throws Exception {
        Long userId = 1L;
        User user = new User(userId, "testUser");
        when(userService.getUserById(userId)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/users/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(userId));

        verify(userService, times(1)).getUserById(userId);
    }

    @Test
    void getUserById_UserNotExists() throws Exception {
        Long userId = 1L;
        when(userService.getUserById(userId)).thenReturn(Optional.empty());

        mockMvc.perform(get("/users/{userId}", userId))
                .andExpect(status().isNotFound());

        verify(userService, times(1)).getUserById(userId);
    }

    @Test
    void createUser() throws Exception {
        String username = "newUser";
        User newUser = new User(1L, username);
        when(userService.createUser(username)).thenReturn(newUser);

        ResultActions result = mockMvc.perform(post("/users")
                .param("username", username)
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L));

        verify(userService, times(1)).createUser(username);
    }

    @Test
    void updateUser_UserExists() throws Exception {
        Long userId = 1L;
        String newUsername = "updatedUser";
        User updatedUser = new User(userId, newUsername);
        when(userService.updateUser(userId, newUsername)).thenReturn(updatedUser);

        ResultActions result = mockMvc.perform(put("/users/{userId}", userId)
                .param("newUsername", newUsername)
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("updatedUser"));

        verify(userService, times(1)).updateUser(userId, newUsername);
    }

    @Test
    void updateUser_UserNotExists() throws Exception {
        Long userId = 1L;
        String newUsername = "updatedUser";
        when(userService.updateUser(userId, newUsername)).thenReturn(null);

        mockMvc.perform(put("/users/{userId}", userId)
                .param("newUsername", newUsername)
                .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isNotFound());

        verify(userService, times(1)).updateUser(userId, newUsername);
    }

    @Test
    void deleteUser() throws Exception {
        mockMvc.perform(delete("/users/{userId}", 1L))
                .andExpect(status().isOk());

        verify(userService, times(1)).deleteUser(1L);
    }
}
