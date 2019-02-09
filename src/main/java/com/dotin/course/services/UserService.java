package com.dotin.course.services;

import com.dotin.course.entities.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> getAll();

    static UserService GET(){
        return new UserServiceImpl();
    }
}
