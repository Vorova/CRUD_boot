package com.vorova.crud_boot.dao;

import jakarta.persistence.EntityManager;
import com.vorova.crud_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> allUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }
}
