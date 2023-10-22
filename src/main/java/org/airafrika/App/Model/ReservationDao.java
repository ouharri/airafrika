package org.airafrika.App.Model;

import jakarta.enterprise.inject.Model;
import org.airafrika.App.Entities.Reservation;
import org.airafrika.Libs.Dao;

@Model
public class ReservationDao extends Dao<Reservation> {
}
