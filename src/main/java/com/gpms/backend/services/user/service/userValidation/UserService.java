package com.gpms.backend.services.user.service.userValidation;

import com.gpms.backend.services.user.dto.request.LoginRequest;
import com.gpms.backend.services.user.dto.request.UserRequest;
import com.gpms.backend.services.user.dto.response.LoginResponce;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void createUser(UserRequest userRequest);
    LoginResponce login(LoginRequest loginRequest);


}
