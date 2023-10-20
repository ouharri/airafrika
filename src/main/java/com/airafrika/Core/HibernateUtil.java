package com.airafrika.Core;

import jakarta.persistence.EntityManagerFactory;
import lombok.Getter;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

/**
 * HibernateUtil is a utility class for managing Hibernate EntityManagerFactory
 * and initializing the Hibernate configuration for your application.
 */
public class HibernateUtil {

    /**
     * The EntityManagerFactory used for managing entity objects.
     */
    @Getter
    private static volatile EntityManagerFactory entityManagerFactory = null;

    private HibernateUtil() {
    }

    static {
        if (entityManagerFactory == null) {
            synchronized (HibernateUtil.class) {
                if (entityManagerFactory == null) {
                    try {
                        Configuration configuration = new Configuration();
                        configuration.setProperties(loadHibernateProperties());

                        addAnnotatedClasses(configuration);

                        StandardServiceRegistryBuilder serviceRegistryBuilder =
                                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

                        entityManagerFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());
                    } catch (Throwable ex) {
                        System.err.println("Initial SessionFactory creation failed: " + ex);
                        throw new ExceptionInInitializerError(ex);
                    }
                }
            }
        }
    }

    /**
     * Adds annotated entity classes to the Hibernate configuration.
     *
     * @param configuration The Hibernate Configuration instance.
     */
    private static void addAnnotatedClasses(Configuration configuration) {
        configuration
                .addAnnotatedClass(com.airafrika.App.Entities.Admin.class)
                .addAnnotatedClass(com.airafrika.App.Entities.Plane.class)
                .addAnnotatedClass(com.airafrika.App.Entities.CompanyAerial.class)
                .addAnnotatedClass(com.airafrika.App.Entities.Airport.class)
                .addAnnotatedClass(com.airafrika.App.Entities.Flight.class)
                .addAnnotatedClass(com.airafrika.App.Entities.FlightSchedule.class)
                .addAnnotatedClass(com.airafrika.App.Entities.Passenger.class)
                .addAnnotatedClass(com.airafrika.App.Entities.Reservation.class)
                .addAnnotatedClass(com.airafrika.App.Entities.Itinerary.class)
                .addAnnotatedClass(com.airafrika.App.Entities.Flightpath.class)
                .addAnnotatedClass(com.airafrika.App.Entities.Plane.class)
                .addAnnotatedClass(com.airafrika.App.Entities.ReservationExtra.class)
                .addAnnotatedClass(com.airafrika.App.Entities.Extra.class)
                .addAnnotatedClass(com.airafrika.App.Entities.Paiement.class);
    }

    /**
     * Loads the Hibernate properties from the environment variables.
     *
     * @return The Hibernate properties.
     */
    private static Properties loadHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.url", System.getenv("DB_URL"));
        properties.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"));
        properties.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"));
        properties.setProperty("hibernate.connection.driver_class", System.getenv("JDBC_DRIVER"));
        properties.setProperty("hibernate.dialect", System.getenv("JPA_DIALECT"));
        properties.setProperty("hibernate.show_sql", System.getenv("HIBERNATE_SHOW_SQL"));
        properties.setProperty("hibernate.current_session_context_class", System.getenv("CURRENT_SESSION_CONTEXT_CLASS"));
        properties.setProperty("hibernate.hbm2ddl.auto", System.getenv("HBM2DDL_AUTO"));
        return properties;
    }
}