package com.unityville.IO.controllers;

import com.unityville.IO.entities.User;
import com.unityville.IO.mappers.Mapper;
import com.unityville.IO.models.UserDTO;
import com.unityville.IO.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final Mapper mapper;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllPosts()
                .stream()
                .map(mapper::convertToDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id) {
        User user = userService.findUserById(id);

        if (user == null) {
            return ResponseEntity.ok(new UserDTO());
        }

        return ResponseEntity.ok(mapper.convertToDTO(user));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDTO> findUserByUsername(@PathVariable String username) {
        User user = userService.findUserByUsername(username);

        if (user == null) {
            return ResponseEntity.ok(new UserDTO());
        }

        return ResponseEntity.ok(mapper.convertToDTO(user));
    }

    @PostMapping
    public ResponseEntity<UserDTO> savePost(@RequestBody User user) {
        return new ResponseEntity<>(mapper.convertToDTO(userService.saveUser(user)),
                HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserDTO> putUser(@RequestBody User user) {
        return ResponseEntity.ok(mapper.convertToDTO(userService.saveUser(user)));
    }
}
