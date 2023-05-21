package com.unityville.IO.services;

import com.unityville.IO.entities.Like;
import com.unityville.IO.repositories.LikeRepository;
import jakarta.transaction.Transactional;
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

    public Like saveLike(Like like) {
        return likeRepository.save(like);
    }

    @Transactional
    public Like deleteLikeByUserAndPost(Long userId, Long postId) {
        Like like = likeRepository.findLikeByUserIdAndPostId(userId, postId);
        likeRepository.deleteLikeByUserIdAndPostId(userId, postId);

        return like;
    }

    @Transactional
    public Like deleteLikeByUserAndComment(Long userId, Long commentId) {
        Like like = likeRepository.findLikeByUserIdAndCommentId(userId, commentId);
        likeRepository.deleteByUserIdAndCommentId(userId, commentId);

        return like;
    }
}
