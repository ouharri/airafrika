package org.airafrika.App.Services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.airafrika.App.Entities.Admin;
import org.airafrika.App.Repositories.AdminRepository;

import java.util.List;

@ApplicationScoped
public class AdminService {
    @Inject
    private AdminRepository adminDao;

    public Admin createAdmin(Admin admin){
        return adminDao.create(admin).orElse(null);
    }

    public List<Admin> getAllAdmins(){
        return adminDao.getAll();
    }
}
