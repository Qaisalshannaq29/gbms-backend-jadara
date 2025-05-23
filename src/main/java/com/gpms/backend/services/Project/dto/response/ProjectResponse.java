package com.gpms.backend.services.Project.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class ProjectResponse {
    private Long id;
    private Long creatorId;
    private Long supervisorId;
    private Long categoryId;
    private String title;
    private String status;
    private String comment;
    private LocalDateTime creationDate;
    private boolean deleted;
}
