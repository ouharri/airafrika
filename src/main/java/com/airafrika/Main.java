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
    }
}
