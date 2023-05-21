package com.unityville.IO.controllers;

import com.unityville.IO.entities.Post;
import com.unityville.IO.mappers.Mapper;
import com.unityville.IO.models.PostDTO;
import com.unityville.IO.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/posts_cop")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final Mapper mapper;

    @GetMapping
    public ResponseEntity<List<PostDTO>> findAllPosts() {
        return ResponseEntity.ok(postService.findAllPosts()
                .stream()
                .map(mapper::convertToDTO)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<PostDTO> savePost(@RequestBody Post post) {
        return new ResponseEntity<>(mapper.convertToDTO(postService.save(post)),
                HttpStatus.CREATED);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<PostDTO> getPostByTitle(@PathVariable String title) {
        Post post = postService.getPostByTitle(title);

        if (post == null) {
            return ResponseEntity.ok(new PostDTO());
        }

        return ResponseEntity.ok(mapper.convertToDTO(post));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);

        if (post == null) {
            return ResponseEntity.ok(new PostDTO());
        }

        return ResponseEntity.ok(mapper.convertToDTO(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostDTO> deletePostById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.convertToDTO(postService.deletePostById(id)));
    }

    @PutMapping
    public ResponseEntity<PostDTO> putPost(@RequestBody Post post) {
        return ResponseEntity.ok(mapper.convertToDTO(postService.putPost(post)));
    }
}
