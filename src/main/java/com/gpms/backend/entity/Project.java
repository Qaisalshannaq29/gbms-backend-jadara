package com.gpms.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatorID")
    private User creatorID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SupervisorID")
    private User supervisorID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryID")
    private Category categoryID;

    @Nationalized
    @Column(name = "Title", length = 1000)
    private String title;

    @Nationalized
    @Column(name = "Status", length = 1000)
    private String status;
    @Nationalized
    @Column(name = "Comment", length = 1000)
    private String comment;

    @Column(name = "CreationDate")
    private LocalDateTime creationDate;
    @Column(name = "IsDeleted")
    private Boolean isDeleted;


}