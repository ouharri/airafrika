package com.airafrika.App.Controllers;

import java.io.*;
import java.time.LocalDate;

import com.airafrika.App.Entities.Admin;
import com.airafrika.App.Enums.Gender;
import com.airafrika.Core.HibernateUtil;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";

        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            try {
                tx = session.beginTransaction();
                Admin admn = new Admin();
                admn.setFirstName("John");
                admn.setLastName("Doe");
                admn.setEmail("ouharrioutman@gmail.com");
                admn.setBirthday(LocalDate.parse("1999-01-01"));
                admn.setGender(Gender.MALE);
                admn.setCnie("AD334799");
                admn.setPassword("jfhjhf");
                session.persist(admn);
                tx.commit();
            } catch (Exception e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
            }  finally {
                session.close();
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

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