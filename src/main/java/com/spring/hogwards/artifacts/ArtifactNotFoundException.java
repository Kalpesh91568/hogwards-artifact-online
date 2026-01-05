package com.spring.hogwards.artifacts;

public class ArtifactNotFoundException extends RuntimeException{

    public ArtifactNotFoundException(String id){
        super("Could Not Found Artifact with Id " + id +" : (");
    }
}
