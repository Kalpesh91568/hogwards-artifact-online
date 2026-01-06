package com.spring.hogwards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.hogwards.entity.Wizard;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, Integer> {}
