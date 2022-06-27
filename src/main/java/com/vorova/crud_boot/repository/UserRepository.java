package com.vorova.crud_boot.repository;

import com.vorova.crud_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
