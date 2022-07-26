package ru.alexchmykh.spring.pp_3_1_1_spring_boot.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.alexchmykh.spring.pp_3_1_1_spring_boot.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.unwrap(Session.class).saveOrUpdate(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getListUsers() {
        TypedQuery<User> query=entityManager.unwrap(Session.class).createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUserById(long id) {
        entityManager.remove(getUserById(id));
    }
}
