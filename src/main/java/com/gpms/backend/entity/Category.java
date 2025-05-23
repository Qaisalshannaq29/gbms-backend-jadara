package com.gpms.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Nationalized;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Nationalized
    @Column(name = "Category_Name", length = 1000)
    private String categoryName;

    @Nationalized
    @Column(name = "Description", length = 1000)
    private String description;

}