// package com.spring.hogwards.config;
//
// import com.spring.hogwards.entity.Artifact;
// import com.spring.hogwards.entity.Wizard;
// import com.spring.hogwards.repository.ArtifactRepository;
// import com.spring.hogwards.repository.WizardRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;
//
// @Component
// @RequiredArgsConstructor
// public class DBDataInitializer implements CommandLineRunner {
//
//    private final ArtifactRepository artifactRepository;
//    private final WizardRepository wizardRepository;
//    @Override
//    public void run(String... args) throws Exception {
//
//        Artifact a1 = Artifact.builder()
//                .id("123456")
//                .name("A1")
//                .description("DES1")
//                .imageUrl("img1")
//                .build();
//
//        Artifact a2 = Artifact.builder()
//                .id("147")
//                .name("A2")
//                .description("DES2")
//                .imageUrl("img2")
//                .build();
//
//        Artifact a3 = Artifact.builder()
//                .id("789")
//                .name("A3")
//                .description("DES3")
//                .imageUrl("img3")
//                .build();
//
//        Artifact a4 = Artifact.builder()
//                .id("888")
//                .name("A4")
//                .description("DES4")
//                .imageUrl("img4")
//                .build();
//
//        Artifact a5 = Artifact.builder()
//                .id("555")
//                .name("A5")
//                .description("DES5")
//                .imageUrl("img5")
//                .build();
//
//
//        Wizard w1 =  Wizard.builder()
//                .id(1)
//                .name("Albus")
//                .build();
//        w1.addArtifact(a1);
//        w1.addArtifact(a3);
//        w1.addArtifact(a4);
//        wizardRepository.save(w1);
//
//        Wizard w2 =  Wizard.builder()
//                .id(2)
//                .name("Harry")
//                .build();
//        w1.addArtifact(a1);
//        w1.addArtifact(a2);
//
//
//        wizardRepository.save(w2);
//
//        artifactRepository.save(a5);
//
//    }
// }
