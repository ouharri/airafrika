package org.airafrika.App.Mappers;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import org.airafrika.App.Entities.CompanyAerial;

@Dependent
@Named("CompanyAerialMapper")
public class CompanyAerialMapper {

    @Inject
    CompanyAerial companyAerial;
    public CompanyAerial render(HttpServletRequest request) {

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