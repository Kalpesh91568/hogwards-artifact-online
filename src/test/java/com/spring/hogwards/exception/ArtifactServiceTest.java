//package com.spring.hogwards.exception;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.spring.hogwards.dto.ArtifactDto;
//import com.spring.hogwards.entity.Artifact;
//import com.spring.hogwards.mapper.ArtifactMapper;
//import com.spring.hogwards.repository.ArtifactRepository;
//import com.spring.hogwards.service.ArtifactService;
//
//@ExtendWith(MockitoExtension.class)
//class ArtifactServiceTest {
//
//  @Mock private ArtifactRepository artifactRepository;
//
//  @Mock private ArtifactMapper artifactMapper;
//
//  @InjectMocks private ArtifactService artifactService;
//
//  List<Artifact> artifacts;
//
//  @BeforeEach
//  void setUp() {}
//
//  @AfterEach
//  void tearDown() {}
//
//  @Test
//  void shouldReturnArtifactById() {
//
//    // ARRANGE
//    Integer id = 1;
//
//    Artifact artifact = Artifact.builder().id(id).name("Elder Wand").build();
//
//    ArtifactDto dto = ArtifactDto.builder().id(id).name("Elder Wand").build();
//
//    when(artifactRepository.findById(id)).thenReturn(Optional.of(artifact));
//    when(artifactMapper.toDto(artifact)).thenReturn(dto);
//
//    // ACT
//    ArtifactDto result = artifactService.findById(id);
//
//    // ASSERT
//    assertNotNull(result);
//    assertEquals(id, result.id());
//    assertEquals("Elder Wand", result.name());
//
//    verify(artifactRepository).findById(id);
//    verify(artifactMapper).toDto(artifact);
//  }
//
//  @Test
//  void shouldThrowExceptionWhenArtifactNotFound() {
//
//    // ARRANGE
//    Integer id = 99;
//    when(artifactRepository.findById(id)).thenReturn(Optional.empty());
//
//    // ACT + ASSERT
//    assertThrows(ArtifactNotFoundException.class, () -> artifactService.findById(id));
//
//    verify(artifactRepository).findById(id);
//    verifyNoInteractions(artifactMapper);
//  }
//
//  @Test
//  void shouldReturnAllArtifacts() {
//
//    // ARRANGE
//    Artifact a1 = Artifact.builder().id(1).name("A1").build();
//    Artifact a2 = Artifact.builder().id(2).name("A2").build();
//
//    ArtifactDto d1 = ArtifactDto.builder().id(1).name("A1").build();
//    ArtifactDto d2 = ArtifactDto.builder().id(2).name("A2").build();
//
//    when(artifactRepository.findAll()).thenReturn(List.of(a1, a2));
//    when(artifactMapper.toDto(a1)).thenReturn(d1);
//    when(artifactMapper.toDto(a2)).thenReturn(d2);
//
//    // ACT
//    List<ArtifactDto> result = artifactService.findAll();
//
//    // ASSERT
//    assertEquals(2, result.size());
//    verify(artifactRepository).findAll();
//  }
//
//  @Test
//  void shouldSaveArtifact() {
//
//    // ARRANGE
//    ArtifactDto inputDto = ArtifactDto.builder().name("Invisibility Cloak").build();
//
//    Artifact entity = Artifact.builder().name("Invisibility Cloak").build();
//
//    Artifact savedEntity = Artifact.builder().id(1).name("Invisibility Cloak").build();
//
//    ArtifactDto outputDto = ArtifactDto.builder().id(1).name("Invisibility Cloak").build();
//
//    when(artifactMapper.toEntity(inputDto)).thenReturn(entity);
//    when(artifactRepository.save(entity)).thenReturn(savedEntity);
//    when(artifactMapper.toDto(savedEntity)).thenReturn(outputDto);
//
//    // ACT
//    ArtifactDto result = artifactService.save(inputDto);
//
//    // ASSERT
//    assertNotNull(result);
//    assertEquals(1, result.id());
//
//    verify(artifactMapper).toEntity(inputDto);
//    verify(artifactRepository).save(entity);
//    verify(artifactMapper).toDto(savedEntity);
//  }
//
//  @Test
//  void shouldUpdateArtifact() {
//
//    // ARRANGE
//    Integer id = 1;
//
//    Artifact existing = Artifact.builder().id(id).name("Old Name").build();
//
//    ArtifactDto updateDto = ArtifactDto.builder().name("New Name").build();
//
//    Artifact updated = Artifact.builder().id(id).name("New Name").build();
//
//    ArtifactDto resultDto = ArtifactDto.builder().id(id).name("New Name").build();
//
//    when(artifactRepository.findById(id)).thenReturn(Optional.of(existing));
//    when(artifactRepository.save(existing)).thenReturn(updated);
//    when(artifactMapper.toDto(updated)).thenReturn(resultDto);
//
//    // ACT
//    ArtifactDto result = artifactService.update(id, updateDto);
//
//    // ASSERT
//    assertEquals("New Name", result.name());
//
//    verify(artifactMapper).update(existing, updateDto);
//    verify(artifactRepository).save(existing);
//  }
//
//  @Test
//  void shouldDeleteArtifact() {
//
//    // ARRANGE
//    Integer id = 1;
//    when(artifactRepository.existsById(id)).thenReturn(true);
//
//    // ACT
//    artifactService.delete(id);
//
//    // ASSERT
//    verify(artifactRepository).deleteById(id);
//  }
//
//  @Test
//  void shouldThrowExceptionWhenDeletingNonExistingArtifact() {
//
//    // ARRANGE
//    Integer id = 99;
//    when(artifactRepository.existsById(id)).thenReturn(false);
//
//    // ACT + ASSERT
//    assertThrows(ArtifactNotFoundException.class, () -> artifactService.delete(id));
//
//    verify(artifactRepository).existsById(id);
//    verify(artifactRepository, never()).deleteById(any());
//  }
//}
