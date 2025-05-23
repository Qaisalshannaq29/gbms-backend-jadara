package com.gpms.backend.services.Project.controller;

import com.gpms.backend.services.Project.dto.request.ProjectCreateRequest;
import com.gpms.backend.services.Project.dto.response.ProjectResponse;
import com.gpms.backend.services.Project.service.ProjectValidation.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @PostMapping("/project")
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectCreateRequest request) {
        ProjectResponse response = (ProjectResponse) projectService.createProject(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
