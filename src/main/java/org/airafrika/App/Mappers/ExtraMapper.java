package org.airafrika.App.Mappers;

import jakarta.servlet.http.HttpServletRequest;
import org.airafrika.App.Entities.Extra;

import java.math.BigDecimal;
import java.time.Instant;

public class ExtraMapper {
    public static Extra extraWrapper(HttpServletRequest request) {
        Extra extra = new Extra();

        String name = getParameter(request, "name");
        if (name != null && !name.isEmpty()) {
            extra.setName(name);
        }

        String description = getParameter(request, "description");
        if (description != null && !description.isEmpty()) {
            extra.setDescription(description);
        }

        String priceStr = getParameter(request, "price");
        if (priceStr != null && !priceStr.isEmpty()) {
            BigDecimal price = new BigDecimal(priceStr);
            extra.setPrice(price);
        }

        String picture = getParameter(request, "picture");
        if (picture != null && !picture.isEmpty()) {
            extra.setPicture(picture);
        }

        // Génération de l'horodatage actuel
        extra.setCreatedAt(Instant.now());

        return extra;
    }

    private static String getParameter(HttpServletRequest request, String paramName) {
        String paramValue = request.getParameter(paramName);
        return paramValue != null ? paramValue.trim() : null;
    }
}