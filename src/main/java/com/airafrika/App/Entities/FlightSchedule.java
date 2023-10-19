package com.airafrika.App.Entities;

import com.airafrika.App.Enums.FlightDirection;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flight_schedule")
public class FlightSchedule {
    @Id
    @Column(name = "flight_schedule_id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Column(name = "flight_direction")
    private FlightDirection flightDirection;

    @NotNull
    @Column(name = "departure", nullable = false)
    private Instant departure;
}