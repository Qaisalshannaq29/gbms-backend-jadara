package com.gpms.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProjectID")
    private Project projectID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UploaderID")
    private User uploaderID;

    @Nationalized
    @Column(name = "Title", length = 1000)
    private String title;

    @Nationalized
    @Column(name = "FileType", length = 1000)
    private String fileType;

    @Nationalized
    @Column(name = "FileURL", length = 1000)
    private String fileURL;

    @Column(name = "UploadDate")
    private LocalDateTime uploadDate;

    @Column(name = "IsPublic")
    private Boolean isPublic;

}