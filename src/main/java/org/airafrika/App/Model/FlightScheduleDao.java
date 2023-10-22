package org.airafrika.App.Model;

import jakarta.enterprise.inject.Model;
import org.airafrika.App.Entities.FlightSchedule;
import org.airafrika.Libs.Dao;

@Model
public class FlightScheduleDao extends Dao<FlightSchedule> {
}
