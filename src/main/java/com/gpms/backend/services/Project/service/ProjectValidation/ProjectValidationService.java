package com.gpms.backend.services.Project.service.ProjectValidation;

import com.gpms.backend.services.Project.dto.response.ProjectResponse;

public interface ProjectValidationService {
    void validateUser(String email, String password, String confirmPassword, ProjectResponse response);
}
