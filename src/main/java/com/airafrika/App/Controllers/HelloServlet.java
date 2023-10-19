package com.airafrika.App.Controllers;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.airafrika.App.Entities.*;
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
                Passenger admn = new Passenger();
                admn.setFirstName("John");
                admn.setLastName("Doe");
                admn.setEmail("ouharrioutman@gmail.com");
                admn.setBirthday(LocalDate.parse("1999-01-01"));
                admn.setGender(Gender.MALE);
                admn.setCnie("AD334799");
                admn.setPassword("jfhjhf");
                session.persist(admn);

                Reservation res = new Reservation();
                res.setPassenger(admn);
                session.persist(res);


                Extra ext = new Extra();
                ext.setDescription("hhhfgf");
                ext.setPrice(BigDecimal.valueOf(100));
                ext.setName("test");
                ext.setPicture("test");
                session.persist(ext);

                ReservationExtra reservationExtra = new ReservationExtra();
                reservationExtra.setExtra(ext);
                reservationExtra.setReservation(res);
                session.persist(reservationExtra);


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