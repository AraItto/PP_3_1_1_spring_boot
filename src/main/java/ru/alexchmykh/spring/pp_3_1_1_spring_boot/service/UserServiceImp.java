package ru.alexchmykh.spring.pp_3_1_1_spring_boot.service;

import org.springframework.stereotype.Service;
import ru.alexchmykh.spring.pp_3_1_1_spring_boot.model.User;
import ru.alexchmykh.spring.pp_3_1_1_spring_boot.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void save(User user) {
        if(user.getId()==0) {
            userRepository.save(user);
        } else {
            User userToUpdate = userRepository.getOne(user.getId());
            userToUpdate.setName(user.getName());
            userToUpdate.setSurname(user.getSurname());
            userToUpdate.setAge(user.getAge());
            userToUpdate.setEmail(user.getEmail());
            userRepository.save(userToUpdate);
        }
    }


}
