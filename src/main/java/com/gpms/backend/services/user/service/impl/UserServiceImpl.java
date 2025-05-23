package com.gpms.backend.services.user.service.impl;

import com.gpms.backend.entity.Role;
import com.gpms.backend.entity.User;

import com.gpms.backend.services.Role.repository.RoleRepository;
import com.gpms.backend.services.user.dto.request.LoginRequest;
import com.gpms.backend.services.user.dto.request.UserRequest;
import com.gpms.backend.services.user.dto.response.LoginResponce;
import com.gpms.backend.services.user.enums.UserStatusEnum;
import com.gpms.backend.services.user.repoisitory.UserRepository;
import com.gpms.backend.services.user.service.mapper.UserRequestToUserMapper;
import com.gpms.backend.services.user.service.userValidation.UserService;
import com.gpms.backend.services.user.service.userValidation.UserValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserValidationService userValidationService;
    private final UserRequestToUserMapper userRequestToUserMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public void createUser(UserRequest userRequest) {
        boolean userValidation = userValidationService.validateUser(userRequest.getEmail(), userRequest.getPassword(),userRequest.getConfirmPassword(),userRequest.getRoleId(),userRequest.getUserName());

        if(userValidation) {
            User user = userRequestToUserMapper.apply(userRequest);
            Role role =  roleRepository.findById(userRequest.getRoleId()).orElseThrow();
            user.setRoleID(role);
            userRepository.save(user);
        }else {
            log.error("User is not valid");
        }

    }
    @Override
    public LoginResponce login(LoginRequest loginRequest) {
        User user = userRepository.findByUserName(loginRequest.getUsername());
        if (user == null) {
            return null;
        }
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            log.error("Wrong password");
            return null;
        }
        LoginResponce loginResponce = new LoginResponce();

        loginResponce.setName(user.getName());
        loginResponce.setUserName(user.getUserName());
        loginResponce.setEmail(user.getEmail());
        loginResponce.setRoleId(user.getRoleID().getId());
        loginResponce.setStatus(user.getStatus());

        return loginResponce;
    }
}
