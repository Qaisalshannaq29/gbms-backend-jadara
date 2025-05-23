package com.gpms.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Academic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AcademicID", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UserID", nullable = false)
    private User userID;

    @Nationalized
    @Column(name = "Title", length = 500)
    private String title;

    @Nationalized
    @Column(name = "Specialization", length = 1000)
    private String specialization;

    @Column(name = "JoinDate")
    private LocalDateTime joinDate;

    @OneToMany(mappedBy = "academicID")
    private Set<Department> departments = new LinkedHashSet<>();

}