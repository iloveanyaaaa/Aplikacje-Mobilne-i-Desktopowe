package org.example.controller;

import org.example.model.User;
import org.example.service.IUserService;

public class UserController {
    private final IUserService service;

    public UserController(IUserService service){
        this.service = service;
    }
    public void zapiszUzytkownika(User user){
        service.save(user);
    }
}
