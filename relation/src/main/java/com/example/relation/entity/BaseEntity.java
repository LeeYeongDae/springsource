package com.example.relation.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EnableJpaAuditing
@EntityListeners(value = AuditingEntityListener.class)
public abstract class BaseEntity {

     @CreatedDate
     @Column(updatable = false)
     private LocalDateTime createdDate;

     @LastModifiedDate
     private LocalDateTime updatedDate;
}
