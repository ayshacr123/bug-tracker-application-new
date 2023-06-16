package com.example.bugtrackerapplicationnew.repository;

import com.example.bugtrackerapplicationnew.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom queries can be defined here if needed
}

