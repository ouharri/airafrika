package org.airafrika.App.Mappers;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import org.airafrika.App.Entities.Admin;
import org.airafrika.App.Enums.Gender;

import java.time.LocalDate;

@Dependent
@Named("adminMapper")
public class AdminMapper {
    @Inject
    private Admin admin;

    public Admin render(HttpServletRequest request) {

        String cnie = getParameter(request, "cnie");
        if (cnie != null && !cnie.isEmpty()) {
            admin.setCnie(cnie);
        }

        String firstName = getParameter(request, "firstName");
        if (firstName != null && !firstName.isEmpty()) {
            admin.setFirstName(firstName);
        }

        String lastName = getParameter(request, "lastName");
        if (lastName != null && !lastName.isEmpty()) {
            admin.setLastName(lastName);
        }

        String email = getParameter(request, "email");
        if (email != null && !email.isEmpty()) {
            admin.setEmail(email);
        }

        String phone = getParameter(request, "phone");
        if (phone != null && !phone.isEmpty()) {
            admin.setPhone(phone);
        }

        String birthdayStr = getParameter(request, "birthday");
        if (birthdayStr != null && !birthdayStr.isEmpty()) {
            LocalDate birthday = LocalDate.parse(birthdayStr);
            admin.setBirthday(birthday);
        }

        String genderStr = getParameter(request, "gender");
        if (genderStr != null && !genderStr.isEmpty()) {
            Gender gender = Gender.valueOf(genderStr);
            admin.setGender(gender);
        }

        String password = getParameter(request, "password");
        if (password != null && !password.isEmpty()) {
            admin.setPassword(password);
        }

        String profilePicture = getParameter(request, "profilePicture");
        if (profilePicture != null && !profilePicture.isEmpty()) {
            admin.setProfilePicture(profilePicture);
        }

        return admin;
    }

    private static String getParameter(HttpServletRequest request, String paramName) {
        String paramValue = request.getParameter(paramName);
        return paramValue != null ? paramValue.trim() : null;
    }
}