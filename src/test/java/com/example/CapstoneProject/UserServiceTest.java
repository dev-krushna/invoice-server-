package com.example.CapstoneProject;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.CapstoneProject.Repository.UserRepository;
import com.example.CapstoneProject.Service.UserService;
import com.example.CapstoneProject.entity.User;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private UserService userService;

    @Mock
    private PasswordEncoder passwordEncoderMock;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUser_Success() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("testpassword");
        user.setEmail("test@example.com");
        user.setRegistrationDate(new Date());

        when(userRepositoryMock.save(any(User.class))).thenReturn(user);
        when(passwordEncoderMock.encode(anyString())).thenReturn("hashedPassword");

        User registeredUser = userService.registerUser(user);

        assertNotNull(registeredUser);
        assertEquals("testuser", registeredUser.getUsername());
        assertEquals("hashedPassword", registeredUser.getPassword());
        assertEquals("test@example.com", registeredUser.getEmail());
        assertNotNull(registeredUser.getRegistrationDate());

        verify(userRepositoryMock, times(1)).save(any(User.class));
        verify(passwordEncoderMock, times(1)).encode(anyString());
    }

    @Test
    public void testRegisterUser_DuplicateUsername() {
        User existingUser = new User();
        existingUser.setUsername("existinguser");

        User newUser = new User();
        newUser.setUsername("existinguser");

        when(userRepositoryMock.findByUsername("existinguser")).thenReturn(existingUser);

        assertThrows(DataIntegrityViolationException.class, () -> {
            userService.registerUser(newUser);
        });

        verify(userRepositoryMock, never()).save(any(User.class));
        verify(passwordEncoderMock, never()).encode(anyString());
    }
}
