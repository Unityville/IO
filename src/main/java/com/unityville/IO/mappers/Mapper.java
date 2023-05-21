package com.unityville.IO.mappers;

import com.unityville.IO.entities.*;
import com.unityville.IO.models.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper {
    private final ModelMapper modelMapper;

    public CommunityOfPracticeDTO convertToDTO(CommunityOfPractice communityOfPractice) {
        return modelMapper.map(communityOfPractice, CommunityOfPracticeDTO.class);
    }

    public GroupDTO convertToDTO(Group group) {
        return modelMapper.map(group, GroupDTO.class);
    }

    public LikeDTO convertToDTO(Like like) {
        return modelMapper.map(like, LikeDTO.class);
    }

    public PostDTO convertToDTO(Post post) {
        return modelMapper.map(post, PostDTO.class);
    }

    public UserDTO convertToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public CommentDTO convertToDTO(Comment comment) {
        return modelMapper.map(comment, CommentDTO.class);
    }
}
