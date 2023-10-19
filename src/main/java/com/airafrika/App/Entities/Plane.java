package com.airafrika.App.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plane")
public class Plane implements Serializable {
    @Id
    @UUID
    @Column(name = "plane_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private java.util.UUID id;

    @Size(max = 255)
    @Column(name = "model")
    private String model;

    @Size(max = 255)
    @Column(name = "description")
    private String description;
}