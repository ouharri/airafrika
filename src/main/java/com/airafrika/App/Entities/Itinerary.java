package com.airafrika.App.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.UUID;
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
@Table(name = "itinerary")
public class Itinerary implements Serializable {
    @Id
    @UUID
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "itinerary_id", nullable = false)
    private java.util.UUID id;

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