package com.spring.hogwards.exception;

import com.spring.hogwards.entity.Artifact;
import com.spring.hogwards.repository.ArtifactRepository;
import com.spring.hogwards.service.ArtifactService;
import com.spring.hogwards.entity.Wizard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ArtifactServiceTest {

    @Mock
    private ArtifactRepository artifactRepository;

    @InjectMocks
    private ArtifactService artifactService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testFindByIdSuccess() {
        // Given : Arrange inputs & targets. Define the behaviour of Mock object artifactRepository

        Wizard wizard =  Wizard.builder()
                .id(2)
                .name("Harry Porter")
                .build();

        Artifact artifact = Artifact.builder()
                .id("123456")
                .name("Test artifact")
                .description("Test Description")
                .imageUrl("Demo URL")
                .owner(wizard)
                .build();

        given(artifactRepository.findById("123456")).willReturn(Optional.of(artifact));

        // When : Act on the target behavior. when steps should cover the method to be tested

        Artifact returnedArtifact = artifactService.findById("123456");

        // Then : Assert Expected Outcomes

        assertThat(returnedArtifact.getId()).isEqualTo(artifact.getId());
        assertThat(returnedArtifact.getName()).isEqualTo(artifact.getName());
        assertThat(returnedArtifact.getDescription()).isEqualTo(artifact.getDescription());
        assertThat(returnedArtifact.getImageUrl()).isEqualTo(artifact.getImageUrl());
        assertThat(returnedArtifact.getOwner()).isEqualTo(artifact.getOwner());

        verify(artifactRepository,times(1)).findById("123456");
    }

    @Test
    void testFindByIdNotFound(){

        // Given
        given(artifactRepository.findById(Mockito.any(String.class))).willReturn(Optional.empty());

        // When
        Throwable thrown = catchThrowable(()-> { Artifact returnedArtifact = artifactService.findById("123456");});

        // Then
        assertThat(thrown).isInstanceOf(ArtifactNotFoundException.class)
                .hasMessage("Could Not Found Artifact with Id 123456 : (");

        verify(artifactRepository,times(1)).findById("123456");

    }
}