package com.gpms.backend.services.user.service.mapper;

import com.gpms.backend.entity.User;
import com.gpms.backend.services.user.dto.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class UserRequestToUserMapper implements Function<UserRequest, User> {
    @Override
    public User apply(UserRequest userRequest) {
        return User.builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .createdAt(LocalDateTime.now())
                .status(userRequest.getStatus())
                .name(userRequest.getName())
                .userName(userRequest.getUserName())
                .build();
    }
}
