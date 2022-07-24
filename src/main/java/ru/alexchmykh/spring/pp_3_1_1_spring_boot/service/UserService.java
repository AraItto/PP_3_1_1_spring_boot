package ru.alexchmykh.spring.pp_3_1_1_spring_boot.service;

import ru.alexchmykh.spring.pp_3_1_1_spring_boot.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Long userId);

    List<User> getAllUsers();

    void deleteUserById(Long id);

    void save(User user);


}
