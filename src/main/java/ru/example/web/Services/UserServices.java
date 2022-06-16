package ru.example.web.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.web.Model.User;
import ru.example.web.Repositories.UserRepositories;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServices {

    private final UserRepositories userRepositories;

    @Autowired
    public UserServices(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public List<User> getAllUsers(){
        return userRepositories.findAll();
    }

    public void createUser(User user){
        userRepositories.save(user);
    }

    public User getUser(int id){
       Optional<User> user = userRepositories.findById(id);
       return user.orElse(null);
    }

    public void updateUser(User user){
        userRepositories.save(user);
    }

    public void deleteUser(int id){
        userRepositories.deleteById(id);
    }

}
