//package com.spring.hogwards.controller;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.spring.hogwards.dto.ArtifactDto;
//import com.spring.hogwards.dto.StatusCode;
//import com.spring.hogwards.service.ArtifactService;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class ArtifactControllerTest {
//
//  @MockitoBean private ArtifactService artifactService;
//
//  @Autowired private MockMvc mockMvc;
//
//  @Autowired private ObjectMapper objectMapper;
//
//  private static final String CONTEXT = "/api/v1/artifacts";
//
//  @Test
//  void shouldReturnArtifactById() throws Exception {
//
//    ArtifactDto dto = ArtifactDto.builder().id(1).name("Elder Wand").build();
//
//    when(artifactService.findById(1)).thenReturn(dto);
//
//    mockMvc
//        .perform(get("/1"))
//        .andExpect(status().isOk())
//        .andExpect(jsonPath("$.flag").value(true))
//        .andExpect(jsonPath("$.code").value(StatusCode.SUCCESS))
//        .andExpect(jsonPath("$.message").value("Found One Success"))
//        .andExpect(jsonPath("$.data.id").value(1))
//        .andExpect(jsonPath("$.data.name").value("Elder Wand"));
//  }
//
//  @Test
//  void shouldReturnAllArtifacts() throws Exception {
//
//    ArtifactDto d1 = ArtifactDto.builder().id(1).name("A1").build();
//    ArtifactDto d2 = ArtifactDto.builder().id(2).name("A2").build();
//
//    when(artifactService.findAll()).thenReturn(List.of(d1, d2));
//
//    mockMvc
//        .perform(get("/"))
//        .andExpect(status().isOk())
//        .andExpect(jsonPath("$.flag").value(true))
//        .andExpect(jsonPath("$.code").value(StatusCode.SUCCESS))
//        .andExpect(jsonPath("$.message").value("Find All Success"))
//        .andExpect(jsonPath("$.data.length()").value(2));
//  }
//
//  @Test
//  void shouldCreateArtifact() throws Exception {
//
//    ArtifactDto input = ArtifactDto.builder().name("Invisibility Cloak").build();
//
//    ArtifactDto saved = ArtifactDto.builder().id(1).name("Invisibility Cloak").build();
//
//    when(artifactService.save(any(ArtifactDto.class))).thenReturn(saved);
//
//    mockMvc
//        .perform(
//            post("/")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(input)))
//        .andExpect(status().isCreated())
//        .andExpect(jsonPath("$.flag").value(true))
//        .andExpect(jsonPath("$.code").value(StatusCode.CREATED))
//        .andExpect(jsonPath("$.message").value("SuccessFully Created"))
//        .andExpect(jsonPath("$.data.id").value(1));
//  }
//
//  //    @Test
//  //    void shouldUpdateArtifact() throws Exception {
//  //
//  //        ArtifactDto updateDto = ArtifactDto.builder()
//  //                .name("Updated Name")
//  //                .build();
//  //
//  //        ArtifactDto updated = ArtifactDto.builder()
//  //                .id(1)
//  //                .name("Updated Name")
//  //                .build();
//  //
//  //        when(artifactService.update(eq(1), any(ArtifactDto.class)))
//  //                .thenReturn(updated);
//  //
//  //        mockMvc.perform(put( "/1")
//  //                        .contentType(MediaType.APPLICATION_JSON)
//  //                        .content(objectMapper.writeValueAsString(updateDto)))
//  //                .andExpect(status().isOk())
//  //                .andExpect(jsonPath("$.flag").value(true))
//  //                .andExpect(jsonPath("$.code").value(StatusCode.SUCCESS))
//  //                .andExpect(jsonPath("$.message").value("SuccessFully Updated"))
//  //                .andExpect(jsonPath("$.data.name").value("Updated Name"));
//  //    }
//
//  @Test
//  void shouldDeleteArtifact() throws Exception {
//
//    doNothing().when(artifactService).delete(1);
//
//    mockMvc
//        .perform(delete("/1"))
//        .andExpect(status().isNoContent())
//        .andExpect(jsonPath("$.flag").value(true))
//        .andExpect(jsonPath("$.code").value(StatusCode.NO_CONTENT))
//        .andExpect(jsonPath("$.message").value("Successfully Deleted"));
//  }
//}
