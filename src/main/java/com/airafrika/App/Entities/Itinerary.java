package com.airafrika.App.Entities;

import jakarta.persistence.*;
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
@Table(name = "itinerary")
public class Itinerary {
    @Id
    @Column(name = "itinerary_id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_schedule_id")
    private FlightSchedule flightSchedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_path_id")
    private Flightpath flightPath;

    @Column(name = "created_at")
    private Instant createdAt;

}