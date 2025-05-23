package com.gpms.backend.services.user.service.userValidation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface UserValidationService {
    boolean isUserExist(String email);
    boolean isPasswordValid(String password, String confirmPassword);
    boolean isEmailValid(String email);
    boolean isRoleExist(Long role);
    boolean isUserNameExist(String username);
    boolean validateUser(String email, String password, String confirmPassword,Long role, String username);
}
