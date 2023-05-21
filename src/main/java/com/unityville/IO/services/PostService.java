package com.unityville.IO.services;

import com.unityville.IO.entities.Post;
import com.unityville.IO.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post save(Post post) {
        post.setCreateTimestamp(Timestamp.from(Instant.now()));
        return postRepository.save(post);
    }

    public Post getPostByTitle(String title) {
        Optional<Post> post = postRepository.findPostByTitle(title);
        return post.orElse(null);
    }

    public Post getPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElse(null);
    }

    public Post deletePostById(Long id) {
        Post post = postRepository.getReferenceById(id);
        postRepository.deleteById(id);

        return post;
    }

    public Post putPost(Post post) {
        return postRepository.save(post);
    }
}
