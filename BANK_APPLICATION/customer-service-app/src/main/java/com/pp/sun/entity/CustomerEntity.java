package com.pp.sun.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@Table(name = "customers",
uniqueConstraints = {
        @UniqueConstraint(name = "uniq_customer_email", columnNames = "email"),
        @UniqueConstraint(name = "uniq_external_id" , columnNames = "external_id")
}
)

public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    @Column(name ="first_name",nullable = false )
    private String firstName;

    @Column(name ="middle_name",nullable = true )
    private String middleName;

    @Column(name ="last_name",nullable = false )
    private String lastName;

    @Column(name ="email",nullable = false )
    private String email;

    @Column(name ="mobile_number",nullable = false )
    private String mobileNumber;

    @Column(name ="address",nullable = false )
    private String address;

    @Column(name ="address",nullable = false ,unique = true)
    private String externalId; // use as idempotency key

    @Enumerated(EnumType.STRING)
    @Column(name = "kyc_status" ,nullable = false)
    private KycStatus kycStatus;

    @Column(name = "active" ,nullable = false)
    private Boolean active;

    @Column(name = "request_fingerprint" ,nullable = false)
    private String requestFingerprint;

    @Column(name = "created_ts" ,nullable = false)
    private LocalDateTime createdTs;

    @Column(name = "updated_ts" ,nullable = false)
    private LocalDateTime updatedTs;


}
