package com.spring.hogwards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Artifact implements Serializable {

    @Id
    private String id;
    private String name;
    private String description;
    private String imageUrl;

    @ManyToOne
    private Wizard owner;
}
