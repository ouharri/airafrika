package com.airafrika.App.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "paiement")
public class Paiement {
    @Id
    @Column(name = "paiement_id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @Size(max = 255)
    @NotNull
    @Column(name = "payment_status", nullable = false)
    private String paymentStatus;

    @NotNull
    @Column(name = "payment_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal paymentAmount;

    @Size(max = 255)
    @NotNull
    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "created_at")
    private Instant createdAt;
}