package com.vorova.crud_boot.dao;

import com.vorova.crud_boot.model.User;

import java.util.List;

public interface UserDao {

    List<User> allUsers();
    void add(User user);
    void update(User user);
    void delete(long id);
    User getById(long id);

}
