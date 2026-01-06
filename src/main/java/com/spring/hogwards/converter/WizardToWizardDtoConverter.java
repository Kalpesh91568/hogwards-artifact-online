package com.spring.hogwards.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.spring.hogwards.dto.WizardDto;
import com.spring.hogwards.entity.Wizard;

@Component
public class WizardToWizardDtoConverter implements Converter<Wizard, WizardDto> {
  @Override
  public WizardDto convert(Wizard source) {

    return new WizardDto(source.getId(), source.getName(), source.getNumberOfArtifacts());
  }
}
