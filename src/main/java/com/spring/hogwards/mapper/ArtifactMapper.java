package com.spring.hogwards.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.spring.hogwards.dto.ArtifactDto;
import com.spring.hogwards.entity.Artifact;



@Mapper(componentModel = "spring")
public interface ArtifactMapper {

  // Entity To Dto

  ArtifactDto toDto(Artifact artifact);

  // Dto To Entity

  Artifact toEntity(ArtifactDto artifactDto);

  // @MappingTarget tells MapStruct to update an EXISTING object instead of creating a new one.
  void update(@MappingTarget Artifact artifact, ArtifactDto artifactDto);
}
