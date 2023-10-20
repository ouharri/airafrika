package org.airafrika.App.Mappers;

import jakarta.servlet.http.HttpServletRequest;
import org.airafrika.App.Entities.CompanyAerial;

public class CompanyAerialMapper {
    public static CompanyAerial companyAerialWrapper(HttpServletRequest request) {
        CompanyAerial companyAerial = new CompanyAerial();

        String name = getParameter(request, "name");
        if (name != null && !name.isEmpty()) {
            companyAerial.setName(name);
        }

        String logo = getParameter(request, "logo");
        if (logo != null && !logo.isEmpty()) {
            companyAerial.setLogo(logo);
        }

        return companyAerial;
    }

    private static String getParameter(HttpServletRequest request, String paramName) {
        String paramValue = request.getParameter(paramName);
        return paramValue != null ? paramValue.trim() : null;
    }
}