package com.spring.hogwards.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wizard implements Serializable {

    @Id
    private Integer id;
    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "owner")
    private List<Artifact> artifacts;
}
