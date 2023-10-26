package org.airafrika.Core;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Alternative;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;
import lombok.Getter;
import org.airafrika.App.Providers.HibernatePersistenceProvider;
import org.airafrika.Config.PersistenceUnitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * `HibernateUtil` is a utility class for managing the Hibernate `EntityManagerFactory`.
 * It initializes the Hibernate configuration for your application.
 */
@Dependent
public class HibernateUtil {

    /**
     * The `EntityManagerFactory` used for managing entity objects.
     */
    @Getter
    @Produces
    private static volatile EntityManagerFactory entityManagerFactory = null;

    @Inject
    private volatile PersistenceUnitConfig persistenceUnitInfo;

    @Inject
    private volatile HibernatePersistenceProvider hibernatePersistenceProvider;

    protected volatile static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

    /**
     * Initializes the `EntityManagerFactory` and returns it.
     *
     * @return The initialized `EntityManagerFactory`.
     * @throws ExceptionInInitializerError if the initialization fails.
     */
    public EntityManagerFactory init() {
        if (entityManagerFactory == null) {
            synchronized (HibernateUtil.class) {
                if (entityManagerFactory == null) {
                    try {
                        entityManagerFactory = hibernatePersistenceProvider
                                .createContainerEntityManagerFactory(
                                        persistenceUnitInfo,
                                        persistenceUnitInfo.getProperties()
                                );
                    } catch (Throwable ex) {
                        logger.error("Initial SessionFactory creation failed", ex);
                        throw new ExceptionInInitializerError(ex);
                    }
                }
            }
        }
        return entityManagerFactory;
    }
}