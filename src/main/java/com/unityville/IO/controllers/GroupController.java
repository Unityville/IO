package com.unityville.IO.controllers;

import com.unityville.IO.entities.Group;
import com.unityville.IO.mappers.Mapper;
import com.unityville.IO.models.GroupDTO;
import com.unityville.IO.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/groups_cop")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
    private final Mapper mapper;

    @GetMapping
    public ResponseEntity<List<GroupDTO>> findAllGroups() {
        return ResponseEntity.ok(groupService.findAllGroups()
                .stream()
                .map(mapper::convertToDTO)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<GroupDTO> save(@RequestBody Group group) {
        return new ResponseEntity<>(mapper.convertToDTO(groupService.save(group)),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getGroupById(@PathVariable Long id) {
        Group group = groupService.getGroupById(id);

        if (group == null) {
            return ResponseEntity.ok(new GroupDTO());
        }

        return ResponseEntity.ok(mapper.convertToDTO(groupService.getGroupById(id)));
    }

    @PutMapping
    public ResponseEntity<GroupDTO> putGroup(@RequestBody Group group) {
        return ResponseEntity.ok(mapper.convertToDTO(groupService.putGroup(group)));
    }

}
