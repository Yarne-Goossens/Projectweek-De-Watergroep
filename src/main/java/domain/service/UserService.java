package domain.service;

import domain.model.User;

import java.util.ArrayList;

public interface UserService {
    void addUser(User user);

    User findUserWithEmail(String email);

    ArrayList<User> getAllUsers();
}
