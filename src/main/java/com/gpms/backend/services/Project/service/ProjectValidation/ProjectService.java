package com.gpms.backend.services.Project.service.ProjectValidation;

import com.gpms.backend.services.Project.dto.request.ProjectCreateRequest;
import com.gpms.backend.services.Project.dto.response.ProjectResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectResponse> createProject(ProjectCreateRequest request);
}
