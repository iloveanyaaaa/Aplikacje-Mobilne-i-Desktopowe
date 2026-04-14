package org.example.service;

import  org.junit.jupiter.api.Test;
import org.example.model.User;

import  static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    @Test
    void shouldThrowExceptionWhenPasswordTooShort() {
        UserService service = new UserService(null);

        User user = new User("jan", "123");

        assertThrows(IllegalArgumentException.class,
                () -> service.save(user));
    }

}
