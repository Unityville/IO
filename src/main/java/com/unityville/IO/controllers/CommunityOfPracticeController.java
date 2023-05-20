package com.unityville.IO.controllers;

import com.unityville.IO.entities.CommunityOfPractice;
import com.unityville.IO.mappers.Mapper;
import com.unityville.IO.models.CommunityOfPracticeDTO;
import com.unityville.IO.services.CommunityOfPracticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cops")
@RequiredArgsConstructor
public class CommunityOfPracticeController {
    private final CommunityOfPracticeService communityOfPracticeService;
    private final Mapper mapper;

    @PostMapping
    public ResponseEntity<CommunityOfPracticeDTO> save(@RequestBody CommunityOfPractice communityOfPractice) {
        return new ResponseEntity<>(mapper.convertToDTO(communityOfPracticeService.save(communityOfPractice)),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CommunityOfPracticeDTO>> findAllCOP() {
        return ResponseEntity.ok(communityOfPracticeService.findAllCOP()
                .stream()
                .map(mapper::convertToDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunityOfPracticeDTO> getCOPById(@PathVariable Long id) {
        CommunityOfPractice cop = communityOfPracticeService.getCOPById(id);

        if (cop == null) {
            return ResponseEntity.ok(new CommunityOfPracticeDTO());
        }

        return ResponseEntity.ok(mapper.convertToDTO(cop));
    }

    @PutMapping
    public ResponseEntity<CommunityOfPracticeDTO> putCOP(@RequestBody CommunityOfPractice communityOfPractice) {
        return ResponseEntity.ok(mapper.convertToDTO(communityOfPracticeService.putCOP(communityOfPractice)));
    }
}
