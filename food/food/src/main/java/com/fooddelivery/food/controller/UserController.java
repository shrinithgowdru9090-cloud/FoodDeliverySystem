package com.fooddelivery.food.controller;

import com.fooddelivery.food.entity.UserEntity;
import com.fooddelivery.food.repositary.UserRepository; // ✅ THIS LINE IS IMPORTANT
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Tag(name = "User Controller", description = "APIs for managing users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Operation(summary = "Get all users")
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Operation(summary = "Get user by ID")
    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @Operation(summary = "Create a new user")
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @Operation(summary = "Update user by ID")
    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity userDetails) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    @Operation(summary = "Delete user by ID")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
