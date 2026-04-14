package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepository;

public class UserService implements IUserService {
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }
    @Override
    public void save(User user){
        if (user.getPassword().length() < 8){
            throw new IllegalArgumentException("Hasło za krótkie");
        }
        repository.save(user);
    }
}
