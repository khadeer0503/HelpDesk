package com.SpringAI.Helpdesk.entities;

import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Indexed;

import java.time.LocalDateTime;

@Entity
@Slf4j
@Table(name = "tickets", indexes = {
        @Index(name = "idx_ticket_id", columnList = "ticket_id"),
        @Index(name = "idx_ticket_status", columnList = "ticket_status"),
        @Index(name = "idx_ticket_priority", columnList = "ticket_priority"),
        @Index(name = "idx_ticket_email", columnList = "email", unique = true)
})
public class Ticket {
    @Id
    private Long ticket_id;

    @Column(unique = true)
    private String email;

    private String subject;

    @Lob
    private String description;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @Enumerated(EnumType.STRING)
    private Status ticket_status;

    @Enumerated(EnumType.STRING)
    private Priority ticket_priority;
}
