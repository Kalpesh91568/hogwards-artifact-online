package com.spring.hogwards.dto;



public record ArtifactDto(
    Integer id, String name, String description, String imageUrl, WizardDto owner) {}
