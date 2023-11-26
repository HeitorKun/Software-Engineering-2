package com.heitor.softwareEngineering;

import com.heitor.softwareEngineering.domain.User.User;
import com.heitor.softwareEngineering.domain.User.UserRepository;
import com.heitor.softwareEngineering.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Mocking the behavior of userRepository.findAll()
        when(userRepository.findAll()).thenReturn(Arrays.asList(
                new User(1L, "user1"),
                new User(2L, "user2")
        ));

        List<User> userList = userService.getAllUsers();

        assertEquals(2, userList.size());
    }

    @Test
    void testGetUserById() {
        // Mocking the behavior of userRepository.findById()
        when(userRepository.findById(1L)).thenReturn(Optional.of(new User(1L, "user1")));

        Optional<User> user = userService.getUserById(1L);

        assertTrue(user.isPresent());
        assertEquals("user1", user.get().getUsername());
    }

    @Test
    void testCreateUser() {
        // Mocking the behavior of userRepository.save()
        when(userRepository.save(any(User.class))).thenReturn(new User(1L, "user1"));

        User newUser = userService.createUser("user1");

        assertNotNull(newUser);
        assertEquals("user1", newUser.getUsername());
    }

    @Test
    void testUpdateUser() {
        // Mocking the behavior of userRepository.findById() and userRepository.save()
        when(userRepository.findById(1L)).thenReturn(Optional.of(new User(1L, "user1")));
        when(userRepository.save(any(User.class))).thenReturn(new User(1L, "updatedUser1"));

        User updatedUser = userService.updateUser(1L, "updatedUser1");

        assertNotNull(updatedUser);
        assertEquals("updatedUser1", updatedUser.getUsername());
    }

    @Test
    void testUpdateUser_UserNotFound() {
        // Mocking the behavior of userRepository.findById() when user is not found
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        User updatedUser = userService.updateUser(1L, "updatedUser1");

        assertNull(updatedUser);
    }

    @Test
    void testDeleteUser() {
        // Mocking the behavior of userRepository.deleteById()
        userService.deleteUser(1L);

        // Verifying that userRepository.deleteById() was called once with the argument 1L
        verify(userRepository, times(1)).deleteById(1L);
    }
}
