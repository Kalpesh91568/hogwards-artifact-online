package com.spring.hogwards.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.hogwards.dto.ArtifactDto;
import com.spring.hogwards.dto.Result;
import com.spring.hogwards.dto.StatusCode;
import com.spring.hogwards.service.ArtifactService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ArtifactController {

  private final ArtifactService artifactService;

  @GetMapping("/{artifactId}")
  public ResponseEntity<Result> findArtifactById(@PathVariable Integer artifactId) {

    ArtifactDto artifactDto = artifactService.findById(artifactId);
    return new ResponseEntity<>(
        new Result(true, StatusCode.SUCCESS, "Found One Success", artifactDto), HttpStatus.OK);
  }

  @GetMapping("/")
  public ResponseEntity<Result> findAllArtifacts() {
    List<ArtifactDto> artifactDtos = artifactService.findAll();
    return new ResponseEntity<>(
        new Result(true, StatusCode.SUCCESS, "Find All Success", artifactDtos), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Result> saveArtifact(@RequestBody ArtifactDto artifactDto) {
    ArtifactDto dto = artifactService.save(artifactDto);
    return new ResponseEntity<>(
        new Result(true, StatusCode.CREATED, "SuccessFully Created", dto), HttpStatus.CREATED);
  }

  @PutMapping("/{artifactId}")
  public ResponseEntity<Result> updateArtifact(
      @PathVariable Integer artifactID, @RequestBody ArtifactDto artifactDto) {
    ArtifactDto dto = artifactService.update(artifactID, artifactDto);
    return new ResponseEntity<>(
        new Result(true, StatusCode.SUCCESS, "SuccessFully Updated", dto), HttpStatus.OK);
  }

  @DeleteMapping("/{artifactId}")
  public ResponseEntity<Result> deleteArtifact(@PathVariable Integer artifactId) {
    artifactService.delete(artifactId);
    return new ResponseEntity<>(
        new Result(true, StatusCode.NO_CONTENT, "Successfully Deleted", null),
        HttpStatus.NO_CONTENT);
  }
}
