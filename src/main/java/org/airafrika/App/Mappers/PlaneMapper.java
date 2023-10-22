package org.airafrika.App.Mappers;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import org.airafrika.App.Entities.Plane;

@Dependent
@Named("PlaneMapper")
public class PlaneMapper {

    @Inject
    Plane plane;

    public Plane render(HttpServletRequest request) {

        String model = getParameter(request, "model");
        if (model != null && !model.isEmpty()) {
            plane.setModel(model);
        }

        String description = getParameter(request, "description");
        if (description != null && !description.isEmpty()) {
            plane.setDescription(description);
        }

        return plane;
    }

    private static String getParameter(HttpServletRequest request, String paramName) {
        String paramValue = request.getParameter(paramName);
        return paramValue != null ? paramValue.trim() : null;
    }
}
