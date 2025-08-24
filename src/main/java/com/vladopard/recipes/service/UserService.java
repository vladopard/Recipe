package com.vladopard.recipes.service;

import com.vladopard.recipes.entity.User;

import java.util.Optional;

public interface UserService {
    User register(String email, String displayName, String rawPassword);
    Optional<User> findByEmail(String email);
    User getOrThrow(Long id);
}
