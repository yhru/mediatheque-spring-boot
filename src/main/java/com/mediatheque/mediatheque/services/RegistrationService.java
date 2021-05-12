package com.mediatheque.mediatheque.services;

import com.mediatheque.mediatheque.entities.AppUser;
import com.mediatheque.mediatheque.entities.AppUser;
import com.mediatheque.mediatheque.roles.AppUserRole;
import com.mediatheque.mediatheque.requests.RegistrationRequest;
import com.mediatheque.mediatheque.validators.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("email not valid");
        }

        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstname(),
                        request.getLastname(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
