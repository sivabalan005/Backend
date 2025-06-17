package com.ecom.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.userentity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);  // Added method to find by username
}

