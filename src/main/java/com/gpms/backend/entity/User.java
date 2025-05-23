package com.gpms.backend.entity;

import com.gpms.backend.services.user.enums.UserStatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "G_User")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Nationalized
    @Column(name = "Name", length = 100)
    private String name;
    @Nationalized
    @Column(name = "user_name", length = 100)
    private String userName;


    @Nationalized
    @Column(name = "Email", length = 100)
    private String email;

    @Nationalized
    @Column(name = "Password", length = 100)
    private String password;

    @Column(name = "Created_At")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleID")
    private Role roleID;

    private UserStatusEnum status;

}