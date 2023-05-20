package com.unityville.IO.controllers;

import com.unityville.IO.mappers.Mapper;
import com.unityville.IO.models.PostDTO;
import com.unityville.IO.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
