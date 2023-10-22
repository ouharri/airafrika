package org.airafrika.App.Model;

import jakarta.enterprise.inject.Model;
import org.airafrika.App.Entities.Flight;
import org.airafrika.Libs.Dao;

@Model
public class FlightDao extends Dao<Flight> {
}
