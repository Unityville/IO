package com.unityville.IO.mappers;

import com.unityville.IO.entities.CommunityOfPractice;
import com.unityville.IO.entities.Group;
import com.unityville.IO.entities.Like;
import com.unityville.IO.entities.Post;
import com.unityville.IO.models.CommunityOfPracticeDTO;
import com.unityville.IO.models.GroupDTO;
import com.unityville.IO.models.LikeDTO;
import com.unityville.IO.models.PostDTO;
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
}
