package com.gpms.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SenderID")
    private User senderID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ReceiverID")
    private User receiverID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProjectID")
    private Project projectID;

    @Nationalized
    @Column(name = "Message", length = 1000)
    private String message;

    @Column(name = "SentDate")
    private LocalDateTime sentDate;

    @Column(name = "IsRead")
    private Boolean isRead;

}