package com.gpms.backend.services.user.controller;

import com.gpms.backend.services.user.dto.request.LoginRequest;
import com.gpms.backend.services.user.dto.request.UserRequest;
import com.gpms.backend.services.user.dto.response.LoginResponce;
import com.gpms.backend.services.user.enums.UserStatusEnum;
import com.gpms.backend.services.user.service.impl.UserServiceImpl;
import com.gpms.backend.services.user.service.userValidation.UserService;
import jdk.jshell.Snippet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public void createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
    }

    @GetMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        LoginResponce loginResponce=  userService.login(loginRequest);
        if(loginResponce == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        } else if (loginResponce.getStatus().equals(UserStatusEnum.INACTIVE)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("The use is inactive");

        } else {
            return ResponseEntity.ok(loginResponce);
        }

    }
}
