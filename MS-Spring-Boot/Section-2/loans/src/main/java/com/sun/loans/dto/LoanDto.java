package com.sun.loans.dto;

import com.sun.loans.entity.BaseEntity;
import lombok.*;

@ToString
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class LoanDto   {

    private String mobileNumber;
    private String loanNumber;
    private String loanType;
    private Double totalLoanAmount;
    private Double paidAmount;
    private Double outstandingAmount;

}
