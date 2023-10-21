package org.airafrika.App.Controllers;

import java.io.*;
import java.time.LocalDate;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.airafrika.App.Enums.Gender;
import org.airafrika.Dao.AdminDao;
import org.airafrika.Dao.ReservationExtraDao;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.airafrika.App.Entities.Admin;

@RequestScoped
@WebServlet(name = "helloController", value = "/hello")
public class HelloController extends HttpServlet {
    private String message;

    @Inject
    private AdminDao adminDao;

    public void init() {
        message = "Hello World!";

        Admin admin = new Admin();
        admin.setFirstName("John");
        admin.setLastName("Doe");
        admin.setEmail("ouharrioutman@gmail.com");
        admin.setPassword("fgfrg");
        admin.setCnie("123456789");
        admin.setBirthday(LocalDate.now());
        admin.setPhone("123456789");
        admin.setProfilePicture("ff");
        admin.setGender(Gender.MALE);

        adminDao.create(admin);


        adminDao.getAll().forEach((e) -> {
            System.out.println("\n");
            System.out.println(e.toString());
            System.out.println("\n");
        });
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}