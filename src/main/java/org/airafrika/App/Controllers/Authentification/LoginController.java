package org.airafrika.App.Controllers.Authentification;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.airafrika.App.Repositories.AdminRepository;
import org.airafrika.App.Services.AdminService;

import java.io.IOException;

@Controller
@RequestScoped
@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    @Inject
    private AdminService admin;

    @Inject
    private AdminRepository adminDao;

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

        request.getRequestDispatcher("/WEB-INF/views/pages/auth/login.jsp").forward(request, response);
    }


    public void destroy() {
    }
}
