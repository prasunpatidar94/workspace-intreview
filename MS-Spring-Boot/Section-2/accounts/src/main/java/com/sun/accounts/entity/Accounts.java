package com.sun.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends BaseEntity {

    @Id
    @Column(name = "account_number") // dy defaltt but mantion
    private Long accountNumber;
    private Long customerId;
    private String name;
    private String accountType;
    private String branchAddress;
    private String email;
    private String mobileNumber;

}
