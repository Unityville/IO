package com.unityville.IO.repositories;

import com.unityville.IO.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {

    void deleteLikeByUserIdAndPostId(Long userId, Long postId);

    void deleteByUserIdAndCommentId(Long userId, Long postId);

    Like findLikeByUserIdAndPostId(Long userId, Long postId);

    Like findLikeByUserIdAndCommentId(Long userId, Long postId);
}
