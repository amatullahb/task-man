package com.brown.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brown.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail (String email);
}
