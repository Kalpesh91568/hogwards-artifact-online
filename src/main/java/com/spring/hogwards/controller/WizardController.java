package com.spring.hogwards.controller;

import com.spring.hogwards.dto.Result;
import com.spring.hogwards.dto.StatusCode;
import com.spring.hogwards.dto.WizardDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.hogwards.service.WizardService;

import java.util.List;


@RestController
public class WizardController {

  private final WizardService wizardService;

  public WizardController(WizardService wizardService) {
    this.wizardService = wizardService;
  }

  @PostMapping("/wizard")
  public ResponseEntity<Result> createWizard(@RequestBody WizardDto wizardDto){
    WizardDto newWizard = wizardService.createWizard(wizardDto);
    return new ResponseEntity<>(new Result(true, StatusCode.CREATED,"SuccessFully Created",newWizard), HttpStatus.CREATED);
  }

  @GetMapping("/")
  public ResponseEntity<Result> getAllWizards(){
    List<WizardDto> wizardDtos = wizardService.getAllWizards();
    return new ResponseEntity<>(new Result(true, StatusCode.CREATED,"SuccessFully Retrived",wizardDtos), HttpStatus.OK);
  }

  @GetMapping("/{wizardId}")
  public ResponseEntity<Result> getWizardById(@PathVariable Integer wizardId){
    WizardDto wizardDto = wizardService.getById(wizardId);
    return new ResponseEntity<>(new Result(true, StatusCode.CREATED,"SuccessFully Getted",wizardDto), HttpStatus.OK);
  }

  @DeleteMapping("/{wizardId}")
  public ResponseEntity<Result> deleteById(@PathVariable Integer wizardId){
     wizardService.deleteWizard(wizardId);
    return new ResponseEntity<>(
            new Result(true, StatusCode.NO_CONTENT, "Successfully Deleted", null),
            HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{wizardId}")
  public ResponseEntity<Result> updateById(@PathVariable Integer wizardId, @RequestBody WizardDto wizardDto){
    WizardDto w =  wizardService.updateWizard(wizardId, wizardDto);
    return new ResponseEntity<>(
            new Result(true, StatusCode.SUCCESS, "Successfully Updated", null),
            HttpStatus.OK);
  }


}
