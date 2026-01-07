package com.spring.hogwards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.hogwards.dto.Result;
import com.spring.hogwards.dto.StatusCode;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ArtifactNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Result handleArtifactNotFoundException(
      ArtifactNotFoundException artifactNotFoundException) {
    return new Result(false, StatusCode.NOT_FOUND, artifactNotFoundException.getMessage());
  }

  @ExceptionHandler(WizardNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Result handleWizardNotFoundException(
          WizardNotFoundException wizardNotFoundException) {
    return new Result(false, StatusCode.NOT_FOUND, wizardNotFoundException.getMessage());
  }
}
