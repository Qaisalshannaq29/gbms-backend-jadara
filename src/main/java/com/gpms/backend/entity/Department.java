package com.gpms.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AcademicID", nullable = false)
    private Academic academicID;

    @Nationalized
    @Column(name = "DepartmentName", nullable = false, length = 1000)
    private String departmentName;

    @Nationalized
    @Column(name = "Description", length = 1000)
    private String description;

}