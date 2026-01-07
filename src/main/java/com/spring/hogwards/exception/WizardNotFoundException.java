package com.spring.hogwards.exception;

public class WizardNotFoundException extends RuntimeException{
    public WizardNotFoundException(Integer id) {
        super("Could Not Found Artifact with Id " + id + " : (");
    }

}
