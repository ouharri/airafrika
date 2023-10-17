package com.airafrika;

import com.airafrika.App.Entities.Admin;
import com.airafrika.App.Enums.Gender;
import com.airafrika.Core.HibernateUtil;
import com.airafrika.Core.environment;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println(environment.get("DB_URL"));
        System.out.println(environment.get("DB_USERNAME"));
        System.out.println(environment.get("DB_PASSWORD"));
        System.out.println(environment.get("JDBC_DRIVER"));
        System.out.println(environment.get("JPA_DIALECT"));
        System.out.println(environment.get("HIBERNATE_SHOW_SQL"));
        System.out.println("\n\n\n\n\n\n\n\n\n\n");

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
}
