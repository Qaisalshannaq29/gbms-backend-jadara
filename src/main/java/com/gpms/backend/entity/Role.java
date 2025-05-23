package com.gpms.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized
    @Column(name = "RoleName", nullable = false, length = 1000)
    private String roleName;

    @Nationalized
    @Column(name = "Description", length = 1000)
    private String description;

}