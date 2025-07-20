package com.sun.loans.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
@ToString
public class BaseEntity {

    private  String createdBy;
    private LocalDateTime createdAt;
    private  String updatedBy;
    private LocalDateTime updatedAt;
}
