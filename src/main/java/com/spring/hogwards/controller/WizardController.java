package com.spring.hogwards.controller;

import org.springframework.web.bind.annotation.RestController;

import com.spring.hogwards.service.WizardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class WizardController {

  private final WizardService wizardService;
}
