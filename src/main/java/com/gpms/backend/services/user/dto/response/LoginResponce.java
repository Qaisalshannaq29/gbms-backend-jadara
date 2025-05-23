package com.gpms.backend.services.user.dto.response;

import com.gpms.backend.services.user.enums.UserStatusEnum;
import lombok.Data;

@Data
public class LoginResponce {
    private String name;
    private String userName;
    private String email;
    private Long roleId;
    private UserStatusEnum status;
}
