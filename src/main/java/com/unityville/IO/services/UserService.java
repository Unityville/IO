package com.unityville.IO.services;

import com.unityville.IO.entities.User;
import com.unityville.IO.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAllPosts() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public User findUserByUsername(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);
        return user.orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
