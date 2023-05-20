package com.unityville.IO.services;

import com.unityville.IO.entities.CommunityOfPractice;
import com.unityville.IO.repositories.CommunityOfPracticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommunityOfPracticeService {
    private final CommunityOfPracticeRepository communityOfPracticeRepository;

    public CommunityOfPractice save(CommunityOfPractice communityOfPractice) {
        return communityOfPracticeRepository.save(communityOfPractice);
    }

    public List<CommunityOfPractice> findAllCOP() {
        return communityOfPracticeRepository.findAll();
    }

    public CommunityOfPractice getCOPById(Long id) {
        Optional<CommunityOfPractice> cop = communityOfPracticeRepository.findById(id);
        return cop.orElse(null);
    }

    public CommunityOfPractice putCOP(CommunityOfPractice communityOfPractice) {
        return communityOfPracticeRepository.save(communityOfPractice);
    }
}
