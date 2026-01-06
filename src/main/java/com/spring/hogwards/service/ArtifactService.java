package com.spring.hogwards.service;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.spring.hogwards.dto.ArtifactDto;
import com.spring.hogwards.entity.Artifact;
import com.spring.hogwards.exception.ArtifactNotFoundException;
import com.spring.hogwards.mapper.ArtifactMapper;
import com.spring.hogwards.repository.ArtifactRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ArtifactService {

  private final ArtifactRepository artifactRepository;
  private final ArtifactMapper artifactMapper;

  public ArtifactDto findById(Integer artifactId) {
    log.info("Getting Artifact with ID : {} ", artifactId);
    return artifactRepository
        .findById(artifactId)
        .map(artifactMapper::toDto)
        .orElseThrow(() -> new ArtifactNotFoundException(artifactId));
  }

  public List<ArtifactDto> findAll() {
    log.info("Getting All the Artifacts.....");
    return artifactRepository.findAll().stream().map(artifactMapper::toDto).toList();
  }

  public ArtifactDto save(ArtifactDto artifactDto) {
    log.info("Creating new Artifact : {} ", artifactDto);
    Artifact newArtifact = artifactMapper.toEntity(artifactDto);
    newArtifact = artifactRepository.save(newArtifact);
    return artifactMapper.toDto(newArtifact);
  }

  public ArtifactDto update(Integer artifactId, ArtifactDto artifactDto) {
    log.info("Updating Alert with Id : {}", artifactId);
    Artifact artifactExist =
        artifactRepository
            .findById(artifactId)
            .orElseThrow(() -> new ArtifactNotFoundException(artifactId));
    artifactMapper.update(artifactExist, artifactDto);
    artifactExist.setId(artifactId);
    Artifact updatedArtifact = artifactRepository.save(artifactExist);
    return artifactMapper.toDto(updatedArtifact);
  }

  public void delete(Integer artifactId) {
    log.info("Deleting artifact with Id : {}", artifactId);
    boolean isExist = artifactRepository.existsById(artifactId);
    if (isExist) {
      artifactRepository.deleteById(artifactId);
    } else {
      throw new ArtifactNotFoundException(artifactId);
    }
  }
}
