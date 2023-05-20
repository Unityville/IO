package com.unityville.IO.services;

import com.unityville.IO.entities.Like;
import com.unityville.IO.repositories.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;

    public List<Like> findAllLikes() {
        return likeRepository.findAll();
    }
}
