package com.airafrika.Core;

import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {
    private static volatile SessionFactory sessionFactory = null;

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (HibernateUtil.class) {
                if (sessionFactory == null) {
                    try {
                        Configuration configuration = new Configuration();
                        configuration.setProperties(loadHibernateProperties());

                        configuration.addAnnotatedClass(com.airafrika.App.Entities.Plane.class)
                                .addAnnotatedClass(com.airafrika.App.Entities.Admin.class)
                                .addAnnotatedClass(com.airafrika.App.Entities.CompanyAerial.class)
                                .addAnnotatedClass(com.airafrika.App.Entities.Airport.class)
                                .addAnnotatedClass(com.airafrika.App.Entities.Flight.class)
                                .addAnnotatedClass(com.airafrika.App.Entities.FlightSchedule.class)
                                .addAnnotatedClass(com.airafrika.App.Entities.Passenger.class)
                                .addAnnotatedClass(com.airafrika.App.Entities.Reservation.class)
                                .addAnnotatedClass(com.airafrika.App.Entities.Itinerary.class)
                                .addAnnotatedClass(com.airafrika.App.Entities.Flightpath.class)
                                .addAnnotatedClass(com.airafrika.App.Entities.Plane.class)
                                .addAnnotatedClass(com.airafrika.App.Entities.Paiement.class);

                        StandardServiceRegistryBuilder serviceRegistryBuilder =
                                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

                        sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());
                    } catch (Throwable ex) {
                        System.err.println("Initial SessionFactory creation failed: " + ex);
                        throw new ExceptionInInitializerError(ex);
                    }
                }
            }
        }
        return sessionFactory;
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
