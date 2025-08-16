package com.sun.loans.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@ToString
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loans extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;
    private String mobileNumber;
    private String loanNumber;
    private String loanType;
    private Double totalLoanAmount;
    private Double paidAmount;
    private Double outstandingAmount;

}
