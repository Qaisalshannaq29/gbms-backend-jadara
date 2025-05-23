package com.gpms.backend.services.user.service.impl;

import com.gpms.backend.entity.User;
import com.gpms.backend.services.Role.repository.RoleRepository;
import com.gpms.backend.services.user.repoisitory.UserRepository;
import com.gpms.backend.services.user.service.userValidation.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserValidationServiceImpl implements UserValidationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public boolean isUserExist(String email) {
        User user = userRepository.findByEmail(email);
        return user == null;
    }

    @Override
    public boolean isPasswordValid(String password, String confirmPassword) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$";
        return password != null && password.matches(regex);
    }


    @Override
    public boolean isEmailValid(String email) {
       // String regex1 = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$";
        return email!=null && !email.isEmpty() ;
    }

    @Override
    public boolean isRoleExist(Long role) {
        return roleRepository.findById(role).isPresent();
    }

    @Override
    public boolean isUserNameExist(String username) {
        User user =  userRepository.findByUserName(username);
        return user == null;
    }

    @Override
    public boolean validateUser(String email, String password, String confirmPassword, Long role, String username) {
        return isUserExist(email) && isPasswordValid(password, confirmPassword) && isRoleExist(role) && isEmailValid(email) && isUserNameExist(username);


    }
}
