package com.unityville.IO.services;

import com.unityville.IO.entities.Post;
import com.unityville.IO.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
}
