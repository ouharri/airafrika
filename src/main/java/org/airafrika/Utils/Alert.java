package org.airafrika.Utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class Alert {

    public static void add(HttpServletRequest request, String message, String icon) {
        HttpSession session = request.getSession();
        session.setAttribute("alert", new AlertInfo(message, icon));
    }

    public static void add(HttpServletRequest request, String message) {
        HttpSession session = request.getSession();
        session.setAttribute("alert", new AlertInfo(message, "success"));
    }

    public static void notify(HttpServletRequest request) {
        String alert = "";
        HttpSession session = request.getSession();
        AlertInfo alertInfo = (AlertInfo) session.getAttribute("alert");
        if (alertInfo != null) {
            String message = alertInfo.message();
            String icon = alertInfo.icon();
            alert = "<script src='http://airafrika.org/assets/scripts/utils/alert.js'></script>" +
                    "<script>Alert('" + message + "', '" + icon + "');</script>";
            session.removeAttribute("alert");
        }
        request.setAttribute("alert", alert);
    }

    private record AlertInfo(String message, String icon) {
    }
}