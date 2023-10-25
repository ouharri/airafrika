package org.airafrika.App.Services;

import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import org.airafrika.App.Entities.Admin;
import org.airafrika.App.Model.AdminDao;
import org.airafrika.App.Model.PassengerDao;

public class AuthentificationService {

    @Inject
    private AdminDao adminDao;

    @Inject
    private PassengerDao passengerDao;


    public Boolean AuthentificationPassenger(HttpServletRequest request){
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        return passengerDao.findByEmailAndPassword(email,password).isPresent();
    }
}
