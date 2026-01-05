package com.spring.hogwards.wizard;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WizardController {

    private final WizardService wizardService;
}
