package com.airafrika.App.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flight")
public class Flight implements Serializable {
    @Id
    @UUID
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "flight_id", nullable = false)
    private java.util.UUID id;

    @Size(max = 255)
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Size(max = 255)
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @Size(max = 255)
    @NotNull
    @Column(name = "picture", nullable = false)
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plane_id")
    private Plane plane;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_aerial_id")
    private CompanyAerial companyAerial;

    @Column(name = "created_at")
    private Instant createdAt;

    @OneToMany(mappedBy = "flight")
    private Set<Flightpath> flightpaths = new LinkedHashSet<>();

    @OneToMany(mappedBy = "flight")
    private Set<FlightSchedule> flightschedules = new LinkedHashSet<>();
}