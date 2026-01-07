package com.spring.hogwards.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Wizard implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String name;

  @OneToMany(
      cascade = {CascadeType.PERSIST, CascadeType.MERGE},
      mappedBy = "owner")

  private List<Artifact> artifacts = new ArrayList<>();

  public void addArtifact(Artifact artifact) {
    artifact.setOwner(this);
    this.artifacts.add(artifact);
  }

  public Integer getNumberOfArtifacts() {
    return this.artifacts.size();
  }

  public Wizard(){

  }

  public Wizard(Integer id, String name, List<Artifact> artifacts) {
    this.id = id;
    this.name = name;
    this.artifacts = artifacts;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Artifact> getArtifacts() {
    return artifacts;
  }

  public void setArtifacts(List<Artifact> artifacts) {
    this.artifacts = artifacts;
  }
}
