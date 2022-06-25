package ru.example.web.Services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.example.web.Model.User;
import ru.example.web.Repositories.UserRepositories;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private final UserRepositories userRepositories;

    public UserServiceImpl(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public List<User> getAllUsers(){
        return userRepositories.findAll();
    }

    @Transactional
    public void createUser(User user){
        userRepositories.save(user);
    }

    public User getUser(int id){
       Optional<User> user = userRepositories.findById(id);
       return user.orElse(null);
    }

    @Transactional
    public void updateUser(User user){
        userRepositories.save(user);
    }

    @Transactional
    public void deleteUser(int id){
        userRepositories.deleteById(id);
    }

}
