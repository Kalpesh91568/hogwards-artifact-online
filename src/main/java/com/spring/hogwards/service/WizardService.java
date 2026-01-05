package com.spring.hogwards.service;

import com.spring.hogwards.repository.WizardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class WizardService {

    private final WizardRepository wizardRepository;
}
