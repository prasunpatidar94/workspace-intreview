package com.sun.accounts.entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@MappedSuperclass
@Setter @Getter @ToString
public class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(updatable = false)
    private String createdBy = "Admin";

    @Column(insertable = false)
    private LocalDateTime updatedAt = LocalDateTime.now() ;

    @Column(insertable = false)
    private String updatedBy = "Anonymous";




}
