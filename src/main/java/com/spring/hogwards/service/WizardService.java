package com.spring.hogwards.service;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.spring.hogwards.repository.WizardRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class WizardService {

  private final WizardRepository wizardRepository;
}
