package com.spring.hogwards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.hogwards.entity.Artifact;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Integer> {}
