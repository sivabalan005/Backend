package com.ecom.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.userentity.User;
import com.ecom.userrepository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Signup logic with username
    public User signup(String username, String email, String password) {
        if (userRepository.findByUsername(username) != null) {
            throw new RuntimeException("Username already exists.");
        }
        if (userRepository.findByEmail(email) != null) {
            throw new RuntimeException("Email already exists.");
        }
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password);  // Ideally, hash the password before saving
        return userRepository.save(newUser);
    }

    // Login logic with either username or email
    public User login(String usernameOrEmail, String password) {
        User user = userRepository.findByUsername(usernameOrEmail);
        if (user == null) {
            user = userRepository.findByEmail(usernameOrEmail); // Try finding by email if username fails
        }
        
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials.");
        }
        return user;
    }
}
