package org.example.controller;

import org.example.model.User;
import org.example.service.IUserService;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class UserControllerTest {

    @Test
    void shouldCallSaveOnService() {
        IUserService service = mock(IUserService.class);
        UserController controller = new UserController(service);

        User user = new User("jan", "haslo123");

        controller.zapiszUzytkownika(user);

        verify(service).save(user);
    }
}
