package com.sun.loans.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class BaseEntity {

    private  String createdBy;
    private LocalDateTime createdAt;
    private  String updatedBy;
    private LocalDateTime updatedAt;
}
