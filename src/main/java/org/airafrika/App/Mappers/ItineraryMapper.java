package org.airafrika.App.Mappers;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import org.airafrika.App.Entities.Itinerary;
import org.airafrika.App.Entities.Reservation;
import org.airafrika.App.Entities.FlightSchedule;
import org.airafrika.App.Entities.Flightpath;

import java.time.Instant;
import java.util.UUID;

@Dependent
@Named("ItineraryMapper")
public class ItineraryMapper {

    @Inject
    Itinerary itinerary;

    public Itinerary render(HttpServletRequest request) {

        String reservationIdStr = getParameter(request, "reservationId");
        if (reservationIdStr != null && !reservationIdStr.isEmpty()) {
            Reservation reservation = new Reservation();
            reservation.setId(UUID.fromString(reservationIdStr));
            itinerary.setReservation(reservation);
        }

        String flightScheduleIdStr = getParameter(request, "flightScheduleId");
        if (flightScheduleIdStr != null && !flightScheduleIdStr.isEmpty()) {
            FlightSchedule flightSchedule = new FlightSchedule();
            flightSchedule.setId(UUID.fromString(flightScheduleIdStr));
            itinerary.setFlightSchedule(flightSchedule);
        }

        String flightPathIdStr = getParameter(request, "flightPathId");
        if (flightPathIdStr != null && !flightPathIdStr.isEmpty()) {
            Flightpath flightPath = new Flightpath();
            flightPath.setId(UUID.fromString(flightPathIdStr));
            itinerary.setFlightPath(flightPath);
        }

        return itinerary;
    }

    private static String getParameter(HttpServletRequest request, String paramName) {
        String paramValue = request.getParameter(paramName);
        return paramValue != null ? paramValue.trim() : null;
    }
}