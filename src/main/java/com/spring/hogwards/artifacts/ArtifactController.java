package com.spring.hogwards.artifacts;

import com.spring.hogwards.system.Result;
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
