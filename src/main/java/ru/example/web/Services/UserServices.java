package ru.example.web.Services;

import ru.example.web.Model.User;

import java.util.List;

public interface UserServices {

    List<User> getAllUsers();

    void createUser(User user);

    User getUser(int id);

    void updateUser(User user);

    void deleteUser(int id);

}
