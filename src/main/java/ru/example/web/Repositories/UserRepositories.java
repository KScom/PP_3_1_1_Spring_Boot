package ru.example.web.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.web.Model.User;

public interface UserRepositories extends JpaRepository<User, Integer> {


}
