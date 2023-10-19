package com.airafrika.App.Controllers;

import java.io.*;
import java.time.LocalDate;

import com.airafrika.App.Entities.*;
import com.airafrika.App.Enums.Gender;
import com.airafrika.Libs.Dao;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";

        Admin admn = new Admin();
        admn.setFirstName("5daama");
        admn.setLastName("lehna");
        admn.setEmail("ouharrioutman@gmail.com");
        admn.setBirthday(LocalDate.parse("1999-01-01"));
        admn.setGender(Gender.MALE);
        admn.setCnie("AD334799");
        admn.setPassword("jfhjhf");

        System.out.println(new Dao<Admin>().create(admn));
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