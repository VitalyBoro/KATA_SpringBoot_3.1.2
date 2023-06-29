package com.vitfed.spring.springboot.springboot_kata.dao;



import com.vitfed.spring.springboot.springboot_kata.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void save(User user);

    void delete(Long id);

    void update(User user);

    User getById(Long id);
}