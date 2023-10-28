package org.airafrika.App.Controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.airafrika.App.Repositories.AdminRepository;

import java.util.UUID;

@Controller
@RequestScoped
@Path("/admin")
public class AdminController {

    @Inject
    private AdminRepository admin;

    @GET
    @View("pages/auth/login.jsp")
    @Path("/login")
    public String login() {

        System.out.println("\n\n");
        System.out.println("Hello from AdminController.login()");
        System.out.println("\n\n");


        admin.where("email", "ouharrioutman@gmail.com")
                .and("id", UUID.fromString("4e4a2a9b-e8c0-4f3a-b384-bebb5da5df0e"))
                .find().forEach((e) -> {
                    System.out.println("<pre>");
                    System.out.println(e.toString());
                    System.out.println("</pre>");
                });

        return "pages/auth/login.jsp";
    }

    @GET
    @View("pages/authentication")
    @Path("/register")
    public void register() {

    }

    @GET
    @View("admin/allUsers.jsp")
    @Path("/getAllUsers")
    public void getAllUsers() {

    }
}