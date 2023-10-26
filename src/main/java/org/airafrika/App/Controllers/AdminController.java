package org.airafrika.App.Controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.airafrika.App.Services.AdminService;

@RequestScoped
@Controller
@Path("/admin")
public class AdminController {

    @Inject
    private AdminService adminService; // Supposons que vous ayez un service

    @GET
    @View("pages/auth/login.jsp")
    @Path("/login") // Correspond à "/admin/login"
    public void login() {
        // Logique pour gérer la page de connexion
    }

    @GET
    @View("pages/authentication")
    @Path("/register") // Correspond à "/admin/register"
    public void register() {
        // Logique pour gérer la page d'inscription
    }

    @GET
    @View("admin/allUsers.jsp")
    @Path("/getAllUsers") // Correspond à "/admin/getAllUsers"
    public void getAllUsers() {
        // Logique pour afficher tous les utilisateurs
    }

    // Vous pouvez ajouter d'autres actions ici de la même manière
}