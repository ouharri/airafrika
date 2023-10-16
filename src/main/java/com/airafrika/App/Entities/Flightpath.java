package com.airafrika.App.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "flight_path")
public class Flightpath {
    @Id
    @Column(name = "flight_path_id", nullable = false)
    private UUID id;

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