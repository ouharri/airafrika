package com.airafrika.App.Entities;

import com.airafrika.App.Enums.FlightDirection;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flight_schedule")
public class FlightSchedule implements Serializable {
    @Id
    @UUID
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "flight_schedule_id", nullable = false)
    private java.util.UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Column(name = "flight_direction")
    private FlightDirection flightDirection;

    @NotNull
    @Column(name = "departure", nullable = false)
    private Instant departure;
}