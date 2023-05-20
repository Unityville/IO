package com.unityville.IO.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.unityville.IO.entities.Comment;
import com.unityville.IO.services.CommentService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PostDTO {
    private Long id;
    private String title;
    private String text;
    private boolean isPinned;
    private Timestamp createTimestamp;
    private String image;
    private UserDTO user;
    private CommunityOfPracticeDTO communityOfPractice;
    private List<LikeDTO> likes;
}
