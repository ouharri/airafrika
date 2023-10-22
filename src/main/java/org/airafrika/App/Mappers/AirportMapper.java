package org.airafrika.App.Mappers;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import org.airafrika.App.Entities.Airport;

@Dependent
@Named("AirportMapper")
public class AirportMapper {

    @Inject
    Airport airport;
    public Airport render(HttpServletRequest request) {

        String name = getParameter(request, "name");
        if (name != null && !name.isEmpty()) {
            airport.setName(name);
        }

        String address = getParameter(request, "address");
        if (address != null && !address.isEmpty()) {
            airport.setAddress(address);
        }

        String phone = getParameter(request, "phone");
        if (phone != null && !phone.isEmpty()) {
            airport.setPhone(phone);
        }

        String city = getParameter(request, "city");
        if (city != null && !city.isEmpty()) {
            airport.setCity(city);
        }

        String country = getParameter(request, "country");
        if (country != null && !country.isEmpty()) {
            airport.setCountry(country);
        }

        return airport;
    }

    private static String getParameter(HttpServletRequest request, String paramName) {
        String paramValue = request.getParameter(paramName);
        return paramValue != null ? paramValue.trim() : null;
    }
}