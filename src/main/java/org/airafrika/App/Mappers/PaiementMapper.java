package org.airafrika.App.Mappers;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import org.airafrika.App.Entities.Paiement;
import org.airafrika.App.Entities.Reservation;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Dependent
@Named("PaiementMapper")
public class PaiementMapper {

    @Inject
    Paiement paiement;

    public Paiement render(HttpServletRequest request) {

        String reservationIdStr = getParameter(request, "reservationId");
        if (reservationIdStr != null && !reservationIdStr.isEmpty()) {
            Reservation reservation = new Reservation();
            reservation.setId(UUID.fromString(reservationIdStr));
            paiement.setReservation(reservation);
        }

        String paymentStatus = getParameter(request, "paymentStatus");
        if (paymentStatus != null && !paymentStatus.isEmpty()) {
            paiement.setPaymentStatus(paymentStatus);
        }

        String paymentAmountStr = getParameter(request, "paymentAmount");
        if (paymentAmountStr != null && !paymentAmountStr.isEmpty()) {
            BigDecimal paymentAmount = new BigDecimal(paymentAmountStr);
            paiement.setPaymentAmount(paymentAmount);
        }

        String paymentMethod = getParameter(request, "paymentMethod");
        if (paymentMethod != null && !paymentMethod.isEmpty()) {
            paiement.setPaymentMethod(paymentMethod);
        }

        return paiement;
    }

    private static String getParameter(HttpServletRequest request, String paramName) {
        String paramValue = request.getParameter(paramName);
        return paramValue != null ? paramValue.trim() : null;
    }
}
