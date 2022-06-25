package com.vorova.crud_boot.service;

import com.vorova.crud_boot.model.User;

import java.util.List;

public interface UserService {

    List<User> allUsers();
    void add(User user);
    void update(User user);
    void delete(long id);
    User getById(long id);

}
