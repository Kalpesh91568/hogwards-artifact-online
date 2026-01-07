package com.spring.hogwards.service;

import com.spring.hogwards.dto.WizardDto;
import com.spring.hogwards.entity.Wizard;
import com.spring.hogwards.exception.WizardNotFoundException;
import com.spring.hogwards.mapper.WizardMapper;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.spring.hogwards.repository.WizardRepository;

import java.util.List;


@Service
@Transactional
public class WizardService {

  private final WizardRepository wizardRepository;
  private final WizardMapper wizardMapper;

  public WizardService(WizardRepository wizardRepository, WizardMapper wizardMapper) {
    this.wizardRepository = wizardRepository;
    this.wizardMapper = wizardMapper;
  }

  public WizardDto createWizard(WizardDto wizardDto) {
      Wizard wizard = wizardMapper.toEntity(wizardDto);
      wizard = wizardRepository.save(wizard);
      return wizardMapper.toDto(wizard);
    }

    public WizardDto getById(Integer wizardId){
      return wizardRepository.findById(wizardId).map(wizardMapper::toDto).orElseThrow(()->new WizardNotFoundException(wizardId));
    }

    public List<WizardDto> getAllWizards(){
      return wizardRepository.findAll().stream().map(wizardMapper::toDto).toList();
    }

    public WizardDto updateWizard(Integer wizardId, WizardDto wizardDto){

      Wizard existing = wizardRepository.findById(wizardId).orElseThrow(()->new WizardNotFoundException(wizardId));
      wizardMapper.update(existing,wizardDto);
      existing.setId(wizardId);
      Wizard wizard = wizardRepository.save(existing);
      return wizardMapper.toDto(wizard);
    }

    public void deleteWizard(Integer wizardId){
        boolean existing = wizardRepository.existsById(wizardId);
        if (existing){
            wizardRepository.deleteById(wizardId);
        }else {
            throw new WizardNotFoundException(wizardId);
        }

    }
}
