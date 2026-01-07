package com.spring.hogwards.mapper;

import com.spring.hogwards.dto.WizardDto;
import com.spring.hogwards.entity.Wizard;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface WizardMapper {

    //To DTO
    WizardDto toDto(Wizard wizard);

    //ToEntity
    Wizard toEntity(WizardDto wizardDto);

    void update(@MappingTarget  Wizard wizard, WizardDto wizardDto);
}
