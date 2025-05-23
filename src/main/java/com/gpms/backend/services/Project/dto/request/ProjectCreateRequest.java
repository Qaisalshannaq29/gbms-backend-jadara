package com.gpms.backend.services.Project.dto.request;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ProjectCreateRequest {
    private Long creatorId;
    private Long supervisorId;
    private Long categoryId;
    private String title;
    private String status;
    private String comment;
    private LocalDateTime creationDate;
    private boolean deleted;

}
