package com.gpms.backend.services.user.dto.request;

import com.gpms.backend.services.user.enums.UserStatusEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class UserRequest {
    @NonNull
    private String name;
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @NonNull
    private String email;
    @NonNull
    private Long roleId;
    @NonNull
    private UserStatusEnum status;
    @NonNull
    private String confirmPassword;
}
