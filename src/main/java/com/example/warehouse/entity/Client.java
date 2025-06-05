package com.example.warehouse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "client")
@EntityListeners(AuditingEntityListener.class)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "client_id", nullable = false)
    private String clientId;

    @Column(name = "OrganizationName", nullable = false)
    private String OrganizationName;

    @Column(name = "email", nullable = false)
    private String OrganizationEmail;


    @Column(name = "api_key", nullable= false)
    private String apiKey;

    @Column(name = "secret_key",nullable = false)
    private String secretKey;
    @CreatedDate
    @Column(name = "is_active", nullable = false)
    private Instant RegestriedAt;



}
