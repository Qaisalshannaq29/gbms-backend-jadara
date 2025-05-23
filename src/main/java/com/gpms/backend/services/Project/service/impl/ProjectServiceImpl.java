package com.gpms.backend.services.Project.service.impl;

import com.gpms.backend.services.Project.dto.request.ProjectCreateRequest;
import com.gpms.backend.services.Project.dto.response.ProjectResponse;
import com.gpms.backend.services.Project.repoistory.ProjectRepository;
import com.gpms.backend.services.Project.service.ProjectValidation.ProjectService;
import com.gpms.backend.services.Project.service.mapper.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public List<ProjectResponse> createProject(ProjectCreateRequest request) {
        List<ProjectResponse> projects =  projectRepository.findAll().stream().map(projectMapper).toList();
        return projects;
    }
}
