package org.airafrika.App.Mappers;

import jakarta.servlet.http.HttpServletRequest;
import org.airafrika.App.Entities.Flightpath;
import org.airafrika.App.Entities.Flight;
import org.airafrika.App.Entities.Airport;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.UUID;

public class FlightpathMapper {
    public static Flightpath flightpathWrapper(HttpServletRequest request) {
        Flightpath flightpath = new Flightpath();

        String flightIdStr = getParameter(request, "flightId");
        if (flightIdStr != null && !flightIdStr.isEmpty()) {
            Flight flight = new Flight();
            flight.setId(UUID.fromString(flightIdStr));
            flightpath.setFlight(flight);
        }

        String priceStr = getParameter(request, "price");
        if (priceStr != null && !priceStr.isEmpty()) {
            BigDecimal price = new BigDecimal(priceStr);
            flightpath.setPrice(price);
        }

        String downtimeStr = getParameter(request, "downtime");
        if (downtimeStr != null && !downtimeStr.isEmpty()) {
            LocalTime downtime = LocalTime.parse(downtimeStr);
            flightpath.setDowntime(downtime);
        }

        String flightDurationStr = getParameter(request, "flightDuration");
        if (flightDurationStr != null && !flightDurationStr.isEmpty()) {
            LocalTime flightDuration = LocalTime.parse(flightDurationStr);
            flightpath.setFlightDuration(flightDuration);
        }

        String taxingIdStr = getParameter(request, "taxingId");
        if (taxingIdStr != null && !taxingIdStr.isEmpty()) {
            Airport taxing = new Airport();
            taxing.setId(UUID.fromString(taxingIdStr));
            flightpath.setTaxing(taxing);
        }

        String previousStopIdStr = getParameter(request, "previousStopId");
        if (previousStopIdStr != null && !previousStopIdStr.isEmpty()) {
            Flightpath previousStop = new Flightpath();
            previousStop.setId(UUID.fromString(previousStopIdStr));
            flightpath.setPreviousStop(previousStop);
        }

        String nextStopIdStr = getParameter(request, "nextStopId");
        if (nextStopIdStr != null && !nextStopIdStr.isEmpty()) {
            Flightpath nextStop = new Flightpath();
            nextStop.setId(UUID.fromString(nextStopIdStr));
            flightpath.setNextStop(nextStop);
        }

        return flightpath;
    }

    private static String getParameter(HttpServletRequest request, String paramName) {
        String paramValue = request.getParameter(paramName);
        return paramValue != null ? paramValue.trim() : null;
    }
}