package com.airafrika.App.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "plane")
public class Plane {
    @Id
    @Column(name = "plane_id", nullable = false)
    private UUID id;

    @Size(max = 255)
    @Column(name = "model")
    private String model;

    @Size(max = 255)
    @Column(name = "description")
    private String description;
}