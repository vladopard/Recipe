package com.vladopard.recipes.service;

import com.vladopard.recipes.entity.User;
import com.vladopard.recipes.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository users, PasswordEncoder passwordEncoder) {
        this.userRepo = users;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String email, String displayName, String rawPassword) {
        var user = new User();
        user.setEmail(email);
        user.setDisplayName(displayName);
        user.setPassword(passwordEncoder.encode(rawPassword));

        try {
            return userRepo.save(user);
        } catch (DataIntegrityViolationException ex){
            throw ex;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public User getOrThrow(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User with the id" + id + " not found"
                ));
    }
}
