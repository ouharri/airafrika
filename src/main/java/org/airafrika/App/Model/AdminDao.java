package org.airafrika.App.Model;

import jakarta.enterprise.inject.Model;
import org.airafrika.App.Entities.Admin;
import org.airafrika.App.Entities.Passenger;
import org.airafrika.Libs.Dao;

import java.util.Optional;

@Model
public class AdminDao extends Dao<Admin> {
}