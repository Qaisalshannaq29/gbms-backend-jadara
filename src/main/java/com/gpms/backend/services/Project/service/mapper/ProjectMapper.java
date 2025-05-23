package com.gpms.backend.services.Project.service.mapper;

import com.gpms.backend.entity.Project;
import com.gpms.backend.services.Project.dto.response.ProjectResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class ProjectMapper implements Function<Project, ProjectResponse> {
    @Override
    public ProjectResponse apply(Project project) {
        return ProjectResponse.builder()
                .creatorId(project.getId())
                .supervisorId(project.getId())
                .categoryId(project.getId())
                .title(project.getTitle())
                .status(project.getStatus())
                .comment(project.getComment())
                .creationDate(project.getCreationDate())
                .deleted(project.getIsDeleted())
                .build();
    }
}
