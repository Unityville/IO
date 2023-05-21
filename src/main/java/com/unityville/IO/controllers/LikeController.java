package com.unityville.IO.controllers;

import com.unityville.IO.entities.Like;
import com.unityville.IO.mappers.Mapper;
import com.unityville.IO.models.LikeDTO;
import com.unityville.IO.services.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;
    private final Mapper mapper;

    @GetMapping
    public ResponseEntity<List<LikeDTO>> findAllLikes() {
        return ResponseEntity.ok(likeService.findAllLikes()
                .stream()
                .map(mapper::convertToDTO)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<LikeDTO> saveLike(@RequestBody Like like) {
        return new ResponseEntity<>(mapper.convertToDTO(likeService.saveLike(like)),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{userId}/post/{postId}")
    public ResponseEntity<LikeDTO> deleteLikeByUserAndPost(@PathVariable Long userId, @PathVariable Long postId) {
        return ResponseEntity.ok(mapper.convertToDTO(likeService.deleteLikeByUserAndPost(userId, postId)));
    }

    @DeleteMapping("/user/{userId}/comment/{commentId}")
    public ResponseEntity<LikeDTO> deleteLikeByUserAndComment(@PathVariable Long userId, @PathVariable Long commentId) {
        return ResponseEntity.ok(mapper.convertToDTO(likeService.deleteLikeByUserAndComment(userId, commentId)));
    }
}
