package ru.alexchmykh.spring.pp_3_1_1_spring_boot.dao;

import ru.alexchmykh.spring.pp_3_1_1_spring_boot.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> getListUsers();

    User getUserById(long id);

    void deleteUserById(long id);
}
