package com.unityville.IO.controllers;

import com.unityville.IO.mappers.Mapper;
import com.unityville.IO.models.LikeDTO;
import com.unityville.IO.services.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
