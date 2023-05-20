package com.unityville.IO.repositories;

import com.unityville.IO.entities.Like;
import com.unityville.IO.entities.Post;
import com.unityville.IO.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {

    void deleteLikeByUserAndPost(User user, Post post);
}
