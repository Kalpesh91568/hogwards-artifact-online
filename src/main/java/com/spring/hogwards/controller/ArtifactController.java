package com.spring.hogwards.controller;

import com.spring.hogwards.service.ArtifactService;
import com.spring.hogwards.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArtifactController {

    private final ArtifactService artifactService;

    @GetMapping("/{artifactId}")
    public Result findArtifactById(@PathVariable  String artifactId){
        return null;
    }
}
