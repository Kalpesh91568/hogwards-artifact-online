package com.spring.hogwards.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.spring.hogwards.dto.ArtifactDto;
import com.spring.hogwards.entity.Artifact;

@Component
public class ArtifactDtoToArtifactConverter implements Converter<ArtifactDto, Artifact> {
  @Override
  public Artifact convert(ArtifactDto source) {
    Artifact artifact = new Artifact();
    artifact.setName(source.name());
    artifact.setDescription(source.description());
    artifact.setImageUrl(source.imageUrl());
    return artifact;
  }
}
