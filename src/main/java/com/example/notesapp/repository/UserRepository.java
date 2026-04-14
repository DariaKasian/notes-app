package com.example.notesapp.repository;

import com.example.notesapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    //Spring--> читает имя метода: findByUsername
    //SELECT * FROM user WHERE username = ?
}