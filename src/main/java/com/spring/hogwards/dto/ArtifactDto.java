package com.spring.hogwards.dto;

import lombok.Builder;

@Builder
public record ArtifactDto(
    Integer id, String name, String description, String imageUrl, WizardDto owner) {}
