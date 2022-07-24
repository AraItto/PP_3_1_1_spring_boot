package ru.alexchmykh.spring.pp_3_1_1_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexchmykh.spring.pp_3_1_1_spring_boot.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    User getOne(Long id);

    @Override
    void deleteById(Long aLong);

    @Override
    List<User> findAll();

    @Override
    User save(User user);
}
