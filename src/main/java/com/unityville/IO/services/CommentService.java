package com.unityville.IO.services;

import com.unityville.IO.entities.Comment;
import com.unityville.IO.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment deleteCommentById(Long id) {
        Comment comment = commentRepository.getReferenceById(id);
        commentRepository.deleteById(id);

        return comment;
    }

    public Comment getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElse(null);
    }
}
