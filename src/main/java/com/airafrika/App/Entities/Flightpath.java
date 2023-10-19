package com.airafrika.App.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flight_path")
public class Flightpath implements Serializable {
    @Id
    @UUID
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "flight_path_id", nullable = false)
    private java.util.UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @NotNull
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "downtime")
    private LocalTime downtime;

    @Column(name = "flight_duration")
    private LocalTime flightDuration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taxing_id")
    private Airport taxing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "previous_stop_id")
    private Flightpath previousStop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "next_stop_id")
    private Flightpath nextStop;
}