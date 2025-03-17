package com.prime.booking.repository;

import java.util.Optional;

import com.prime.booking.model.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
