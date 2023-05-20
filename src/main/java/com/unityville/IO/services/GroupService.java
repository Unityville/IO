package com.unityville.IO.services;

import com.unityville.IO.entities.CommunityOfPractice;
import com.unityville.IO.entities.Group;
import com.unityville.IO.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public Collection<Group> findAllGroups() {
        return groupRepository.findAll();
    }

    public Group save(Group group) {
        return groupRepository.save(group);
    }

    public Group getGroupById(Long id) {
        Optional<Group> group = groupRepository.findById(id);
        return group.orElse(null);
    }

    public Group putGroup(Group group) {
        return groupRepository.save(group);
    }
}
