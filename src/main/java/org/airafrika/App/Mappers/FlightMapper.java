package org.airafrika.App.Mappers;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import org.airafrika.App.Entities.Flight;
import org.airafrika.App.Entities.Plane;
import org.airafrika.App.Entities.CompanyAerial;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Dependent
@Named("FlightMapper")
public class FlightMapper {

    @Inject
    Flight flight;

    public Flight render(HttpServletRequest request) {

        String title = getParameter(request, "title");
        if (title != null && !title.isEmpty()) {
            flight.setTitle(title);
        }

        String description = getParameter(request, "description");
        if (description != null && !description.isEmpty()) {
            flight.setDescription(description);
        }

        String picture = getParameter(request, "picture");
        if (picture != null && !picture.isEmpty()) {
            flight.setPicture(picture);
        }

        String planeIdStr = getParameter(request, "planeId");
        if (planeIdStr != null && !planeIdStr.isEmpty()) {
            Plane plane = new Plane();
            plane.setId(UUID.fromString(planeIdStr));
            flight.setPlane(plane);
        }

        String companyAerialIdStr = getParameter(request, "companyAerialId");
        if (companyAerialIdStr != null && !companyAerialIdStr.isEmpty()) {
            CompanyAerial companyAerial = new CompanyAerial();
            companyAerial.setId(UUID.fromString(companyAerialIdStr));
            flight.setCompanyAerial(companyAerial);
        }

        flight.setCreatedAt(Instant.now());

        return flight;
    }

    private static String getParameter(HttpServletRequest request, String paramName) {
        String paramValue = request.getParameter(paramName);
        return paramValue != null ? paramValue.trim() : null;
    }
}
