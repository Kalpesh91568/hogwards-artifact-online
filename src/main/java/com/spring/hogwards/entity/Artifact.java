package com.spring.hogwards.entity;

import java.io.Serializable;

import jakarta.persistence.*;


@Entity
public class Artifact implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;
  private String description;
  private String imageUrl;

  @ManyToOne private Wizard owner;

  public Artifact(Integer id, String name, String description, String imageUrl, Wizard owner) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.imageUrl = imageUrl;
    this.owner = owner;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Wizard getOwner() {
    return owner;
  }

  public void setOwner(Wizard owner) {
    this.owner = owner;
  }
}
