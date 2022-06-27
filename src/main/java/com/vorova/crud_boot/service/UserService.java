package com.vorova.crud_boot.service;

import com.vorova.crud_boot.model.User;

import java.util.Optional;

public interface UserService {

    Iterable<User> allUsers();
    void saveOrUpdate(User user);
    void delete(long id);
    Optional<User> getById(long id);
}
