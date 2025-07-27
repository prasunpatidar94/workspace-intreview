package com.sun.card.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class) // listeners  audit  related to activity  (Sping data FW)
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
//            = LocalDateTime.now() ;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy; //add small logic to ge the values (com.sun.accounts.audit.AuditAwareImpl)
//            = "Admin";

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy; //add small logic to ge the values (com.sun.accounts.audit.AuditAwareImpl)


}
