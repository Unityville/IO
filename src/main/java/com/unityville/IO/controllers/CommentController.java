package com.unityville.IO.controllers;

import com.unityville.IO.entities.Comment;
import com.unityville.IO.mappers.Mapper;
import com.unityville.IO.models.CommentDTO;
import com.unityville.IO.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final Mapper mapper;

    @GetMapping
    public ResponseEntity<List<CommentDTO>> findAllComments() {
        return ResponseEntity.ok(commentService.findAllComments()
                .stream()
                .map(mapper::convertToDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);

        if (comment == null) {
            return ResponseEntity.ok(new CommentDTO());
        }

        return ResponseEntity.ok(mapper.convertToDTO(comment));
    }

    @PostMapping
    public ResponseEntity<CommentDTO> saveComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(mapper.convertToDTO(commentService.saveComment(comment)),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommentDTO> deletePostById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.convertToDTO(commentService.deleteCommentById(id)));
    }

    @PutMapping
    public ResponseEntity<CommentDTO> putComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(mapper.convertToDTO(commentService.saveComment(comment)));
    }
}
