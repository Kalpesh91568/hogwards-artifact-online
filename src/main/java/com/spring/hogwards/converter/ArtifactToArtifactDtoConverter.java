//package com.spring.hogwards.converter;
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//import com.spring.hogwards.dto.ArtifactDto;
//import com.spring.hogwards.entity.Artifact;
//
//import lombok.RequiredArgsConstructor;
//
//@Component
//@RequiredArgsConstructor
//public class ArtifactToArtifactDtoConverter implements Converter<Artifact, ArtifactDto> {
//
//  private final WizardToWizardDtoConverter wizardToWizardDtoConverter;
//
//  @Override
//  public ArtifactDto convert(Artifact source) {
//    return new ArtifactDto(
//        source.getId(),
//        source.getName(),
//        source.getDescription(),
//        source.getImageUrl(),
//        source.getOwner() != null ? wizardToWizardDtoConverter.convert(source.getOwner()) : null);
//  }
//}
