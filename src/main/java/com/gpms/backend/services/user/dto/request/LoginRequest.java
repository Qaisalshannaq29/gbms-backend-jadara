package com.gpms.backend.services.user.dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
