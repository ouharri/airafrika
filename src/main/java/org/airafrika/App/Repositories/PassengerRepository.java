package org.airafrika.App.Repositories;

import jakarta.enterprise.inject.Model;
import jakarta.transaction.Transactional;
import org.airafrika.App.Entities.Passenger;
import org.airafrika.Libs.Repository;

import java.util.Optional;

@Model
public class PassengerRepository extends Repository<Passenger> {

    @Transactional
    public Optional<Passenger> findByEmailAndPassword(String email, String password) {
        return Optional.ofNullable(em.createQuery("SELECT p FROM Passenger p WHERE p.email = :email AND p.password = :password", Passenger.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult());
    }

}