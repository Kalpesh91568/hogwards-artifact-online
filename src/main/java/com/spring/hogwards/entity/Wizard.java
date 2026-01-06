package com.spring.hogwards.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wizard implements Serializable {

  @Id private Integer id;
  private String name;

  @OneToMany(
      cascade = {CascadeType.PERSIST, CascadeType.MERGE},
      mappedBy = "owner")
  @Builder.Default
  private List<Artifact> artifacts = new ArrayList<>();

  public void addArtifact(Artifact artifact) {
    artifact.setOwner(this);
    this.artifacts.add(artifact);
  }

  public Integer getNumberOfArtifacts() {
    return this.artifacts.size();
  }
}
