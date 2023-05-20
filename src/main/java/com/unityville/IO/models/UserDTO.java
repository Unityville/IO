package com.unityville.IO.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.unityville.IO.models.GroupDTO;
import com.unityville.IO.models.CommunityOfPracticeDTO;
import com.unityville.IO.models.LikeDTO;
import com.unityville.IO.models.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserDTO {
    private Long id;
    private String username;
    private List<GroupDTO> groups;
    private List<PostDTO> posts;
    private List<CommunityOfPracticeDTO> communityOfPractices;
    private List<LikeDTO> likes;
}
