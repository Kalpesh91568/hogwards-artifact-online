package com.spring.hogwards.exception;

public class ArtifactNotFoundException extends RuntimeException {

  public ArtifactNotFoundException(Integer id) {
    super("Could Not Found Artifact with Id " + id + " : (");
  }
}
