package com.spring.hogwards.controller;

import com.spring.hogwards.service.WizardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WizardController {

    private final WizardService wizardService;
}
