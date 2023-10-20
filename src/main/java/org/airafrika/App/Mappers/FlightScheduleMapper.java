package org.airafrika.App.Mappers;

import jakarta.servlet.http.HttpServletRequest;
import org.airafrika.App.Entities.FlightSchedule;
import org.airafrika.App.Entities.Flight;
import org.airafrika.App.Enums.FlightDirection;

import java.time.Instant;
import java.util.UUID;

public class FlightScheduleMapper {
    public static FlightSchedule flightScheduleWrapper(HttpServletRequest request) {
        FlightSchedule flightSchedule = new FlightSchedule();

        String flightIdStr = getParameter(request, "flightId");
        if (flightIdStr != null && !flightIdStr.isEmpty()) {
            Flight flight = new Flight();
            flight.setId(UUID.fromString(flightIdStr));
            flightSchedule.setFlight(flight);
        }

        String flightDirectionStr = getParameter(request, "flightDirection");
        if (flightDirectionStr != null && !flightDirectionStr.isEmpty()) {
            FlightDirection flightDirection = FlightDirection.valueOf(flightDirectionStr);
            flightSchedule.setFlightDirection(flightDirection);
        }

        String departureStr = getParameter(request, "departure");
        if (departureStr != null && !departureStr.isEmpty()) {
            Instant departure = Instant.parse(departureStr);
            flightSchedule.setDeparture(departure);
        }

        return flightSchedule;
    }

    private static String getParameter(HttpServletRequest request, String paramName) {
        String paramValue = request.getParameter(paramName);
        return paramValue != null ? paramValue.trim() : null;
    }
}