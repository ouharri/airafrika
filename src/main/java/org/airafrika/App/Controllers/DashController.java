package org.airafrika.App.Controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.airafrika.Utils.Alert;

import java.io.IOException;

@Controller
@RequestScoped
@WebServlet(name = "DashController", value = "/dash")
public class DashController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");


//        Alert.add(request,"Aji lhna");

        Alert.notif(request);

        // Rediriger vers la page JSP
        request.getRequestDispatcher("/WEB-INF/views/pages/dash.jsp").forward(request, response);
    }
}
