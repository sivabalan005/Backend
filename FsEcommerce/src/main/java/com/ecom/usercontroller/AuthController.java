package com.ecom.usercontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecom.userentity.User;
import com.ecom.userservice.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Signup API
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        try {
            userService.signup(user.getUsername(), user.getEmail(), user.getPassword());
            return "User registered successfully!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    // Login API
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        try {
            userService.login(user.getUsername(), user.getPassword()); // Username or email can be passed here
            return "Login successful!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
