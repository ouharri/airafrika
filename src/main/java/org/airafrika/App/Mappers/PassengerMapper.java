package org.airafrika.App.Mappers;

import jakarta.servlet.http.HttpServletRequest;
import org.airafrika.App.Entities.Passenger;
import org.airafrika.App.Enums.Gender;

import java.time.LocalDate;

public class PassengerMapper {
    public static Passenger passengerWrapper(HttpServletRequest request) {
        Passenger passenger = new Passenger();

        String cnie = getParameter(request, "cnie");
        if (cnie != null && !cnie.isEmpty()) {
            passenger.setCnie(cnie);
        }

        String firstName = getParameter(request, "firstName");
        if (firstName != null && !firstName.isEmpty()) {
            passenger.setFirstName(firstName);
        }

        String lastName = getParameter(request, "lastName");
        if (lastName != null && !lastName.isEmpty()) {
            passenger.setLastName(lastName);
        }

        String email = getParameter(request, "email");
        if (email != null && !email.isEmpty()) {
            passenger.setEmail(email);
        }

        String phone = getParameter(request, "phone");
        if (phone != null && !phone.isEmpty()) {
            passenger.setPhone(phone);
        }

        String birthdayStr = getParameter(request, "birthday");
        if (birthdayStr != null && !birthdayStr.isEmpty()) {
            LocalDate birthday = LocalDate.parse(birthdayStr);
            passenger.setBirthday(birthday);
        }

        String genderStr = getParameter(request, "gender");
        if (genderStr != null && !genderStr.isEmpty()) {
            Gender gender = Gender.valueOf(genderStr);
            passenger.setGender(gender);
        }

        String password = getParameter(request, "password");
        if (password != null && !password.isEmpty()) {
            passenger.setPassword(password);
        }

        String profilePicture = getParameter(request, "profilePicture");
        if (profilePicture != null && !profilePicture.isEmpty()) {
            passenger.setProfilePicture(profilePicture);
        }

        return passenger;
    }

    private static String getParameter(HttpServletRequest request, String paramName) {
        String paramValue = request.getParameter(paramName);
        return paramValue != null ? paramValue.trim() : null;
    }
}