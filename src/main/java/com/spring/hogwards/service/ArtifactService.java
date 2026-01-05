package com.spring.hogwards.service;

import com.spring.hogwards.entity.Artifact;
import com.spring.hogwards.exception.ArtifactNotFoundException;
import com.spring.hogwards.repository.ArtifactRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ArtifactService {

    private final ArtifactRepository artifactRepository;

    public Artifact findById(String artifactId){
        return artifactRepository.findById(artifactId).orElseThrow(()->new ArtifactNotFoundException(artifactId));
    }
}
