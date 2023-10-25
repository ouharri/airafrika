package org.airafrika.App.Controllers.Authentification;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.airafrika.App.Entities.Admin;
import org.airafrika.App.Enums.Gender;
import org.airafrika.App.Model.AdminDao;
import org.airafrika.Utils.Alert;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestScoped
@WebServlet(name = "login", value = "/login")
public class LoginController extends HttpServlet {

    @Inject
    private Admin admn;

    @Inject
    private AdminDao adminDao;

    public void init() {

//        admn.setFirstName("outmanC");
//        admn.setLastName("Doe");
//        admn.setEmail("otmanoutman@gmail.com");
//        admn.setBirthday(LocalDate.parse("1999-01-01"));
//        admn.setGender(Gender.MALE);
//        admn.setCnie("AD334799");
//        admn.setPassword("jfhjhf");
//
//        adminDao.create(admn);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");


//        Alert.add(request,"Aji lhna");

        Alert.notif(request);

        // Rediriger vers la page JSP
        request.getRequestDispatcher("/pages/auth/login.jsp").forward(request, response);
    }


    public void destroy() {
    }
}
