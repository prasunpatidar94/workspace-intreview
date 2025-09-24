package com.sun.loans.entity;

import jakarta.persistence.Cache;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Calendar;

@MappedSuperclass
@Setter
@Getter
@ToString
public class BaseEntity {

    @Column(updatable = false)
    @CreatedBy
    private  String createdBy;
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();
    @LastModifiedBy
    @Column(insertable = false)
    private  String updatedBy;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt =LocalDateTime.now();
}
