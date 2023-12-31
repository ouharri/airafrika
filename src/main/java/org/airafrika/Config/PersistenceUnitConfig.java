package org.airafrika.Config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

import javax.sql.DataSource;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Named
@ApplicationScoped
public class PersistenceUnitConfig implements PersistenceUnitInfo {

    @Override
    public String getPersistenceUnitName() {
        return "AirAfrika-persistence-unit";
    }

    @Override
    public String getPersistenceProviderClassName() {
        return "jakarta.persistence.jpa.PersistenceProvider";
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return PersistenceUnitTransactionType.valueOf(System.getenv("PERSISTENCE_UNIT_TRANSACTION_TYPE"));
    }

    @Override
    public DataSource getJtaDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(System.getenv("DB_URL"));
        hikariDataSource.setUsername(System.getenv("DB_USERNAME"));
        hikariDataSource.setPassword(System.getenv("DB_PASSWORD"));
        hikariDataSource.setDriverClassName(System.getenv("JDBC_DRIVER"));
        return hikariDataSource;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return null;
    }

    @Override
    public List<URL> getJarFileUrls() {
        return null;
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {
        List<String> classNames = new ArrayList<>();
        classNames.add("org.airafrika.App.Entities.Admin");
        classNames.add("org.airafrika.App.Entities.Plane");
        classNames.add("org.airafrika.App.Entities.CompanyAerial");
        classNames.add("org.airafrika.App.Entities.Airport");
        classNames.add("org.airafrika.App.Entities.Flight");
        classNames.add("org.airafrika.App.Entities.FlightSchedule");
        classNames.add("org.airafrika.App.Entities.Passenger");
        classNames.add("org.airafrika.App.Entities.Reservation");
        classNames.add("org.airafrika.App.Entities.Itinerary");
        classNames.add("org.airafrika.App.Entities.Flightpath");
        classNames.add("org.airafrika.App.Entities.Plane");
        classNames.add("org.airafrika.App.Entities.ReservationExtra");
        classNames.add("org.airafrika.App.Entities.Extra");
        classNames.add("org.airafrika.App.Entities.Paiement");
        return classNames;
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return null;
    }

    @Override
    public ValidationMode getValidationMode() {
        return null;
    }

    @Override
    public Properties getProperties() {
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

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void addTransformer(ClassTransformer classTransformer) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }
}
