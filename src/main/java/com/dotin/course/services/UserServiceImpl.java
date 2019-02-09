package com.dotin.course.services;

import com.dotin.course.entities.User;

import java.util.List;

import static com.dotin.course.util.EMF.runJpaCode;

public class UserServiceImpl implements UserService {

    @Override
    public User save(User user) {
        return runJpaCode(entityManager -> {
            entityManager.persist(user);
            return user;
        }, true);
    }

    @Override
    public List<User> getAll() {
        return runJpaCode(entityManager -> entityManager
                .createQuery("SELECT u FROM User u").getResultList());
    }
}
