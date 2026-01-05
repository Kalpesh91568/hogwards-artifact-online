package com.spring.hogwards.wizard;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class WizardService {

    private final WizardRepository wizardRepository;
}
