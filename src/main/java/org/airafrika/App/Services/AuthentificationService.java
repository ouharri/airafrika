package org.airafrika.App.Services;

import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import org.airafrika.App.Repositories.AdminRepository;
import org.airafrika.App.Repositories.PassengerRepository;

public class AuthentificationService {

    @Inject
    private AdminRepository adminDao;

    @Inject
    private PassengerRepository passengerDao;


    public Boolean AuthentificationPassenger(HttpServletRequest request){
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        return passengerDao.findByEmailAndPassword(email,password).isPresent();
    }
}
