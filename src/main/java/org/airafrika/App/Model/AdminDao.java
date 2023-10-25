package org.airafrika.App.Model;

import jakarta.enterprise.inject.Model;
import org.airafrika.App.Entities.Admin;
import org.airafrika.App.Entities.Passenger;
import org.airafrika.Libs.Dao;

import java.util.Optional;

@Model
public class AdminDao extends Dao<Admin> {

    public Optional<Admin> findByEmailAndPassword(String email, String password) {
        return Optional.ofNullable( em.createQuery("SELECT a FROM Admin a WHERE a.email = :email AND a.password = :password",Admin.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult());
    }
}