package org.airafrika.App.Controllers;

import java.io.*;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import org.airafrika.App.Enums.Gender;
import org.airafrika.App.Model.AdminDao;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.airafrika.App.Entities.Admin;
import org.airafrika.App.Services.AdminService;
import org.airafrika.Utils.Alert;

@Controller
@RequestScoped
@WebServlet(name = "HelloController", value = "/hello")
public class HelloController extends HttpServlet {
    private String message;

    @Inject
    private AdminDao adminService;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        Alert.add(request, "Aji lhna");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Admin admin = new Admin();
        admin.setFirstName("exemle");
        admin.setLastName("Doe");
        admin.setEmail("ouharrioutman@gmail.com");
        admin.setPassword("fgfrg");
        admin.setCnie("123456789");
        admin.setBirthday(LocalDate.now());
        admin.setPhone("123456789");
        admin.setProfilePicture("ff");
        admin.setGender(Gender.MALE);

        adminService.create(admin);

        out.println("<html><body>");
        out.println("<pre>");

        System.out.println(
                adminService.where("email", "ouharrioutman@gmail.com")
                        .and("id", UUID.fromString("4e4a2a9b-e8c0-4f3a-b384-bebb5da5df0e"))
                        .findOne().toString()
        );
        adminService.where("email", "ouharrioutman@gmail.com")
                .and("id", UUID.fromString("4e4a2a9b-e8c0-4f3a-b384-bebb5da5df0e"))
                .find().forEach((e) -> {
                    out.println("<pre>");
                    out.println(e.toString());
                    out.println("</pre>");
                });
        out.println("</pre>");
    }

    public void destroy() {
    }
}