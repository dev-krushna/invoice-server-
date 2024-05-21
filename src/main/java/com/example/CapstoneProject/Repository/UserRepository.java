package com.example.CapstoneProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CapstoneProject.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
