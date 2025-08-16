package com.sun.loans.mapper;

import com.sun.loans.dto.LoanDto;
import com.sun.loans.entity.Loans;

public class LoanMapper {
    public  static Loans mapLoadDtoToLoan(LoanDto loanDto, Loans loans) {

        loans.setMobileNumber(loanDto.getMobileNumber());
        loans.setLoanNumber(loanDto.getLoanNumber());
        loans.setLoanType(loanDto.getLoanType());
        loans.setTotalLoanAmount(loanDto.getTotalLoanAmount());
        loans.setPaidAmount(loanDto.getPaidAmount());
        loans.setOutstandingAmount(loanDto.getOutstandingAmount());

        return loans;
    }
    public static LoanDto mapLoadToLoanDto(Loans loans, LoanDto loanDto) {

        loanDto = new LoanDto.Builder()
                .loanType(loans.getLoanType())
                .mobileNumber(loans.getMobileNumber())
                .loanNumber(loans.getLoanNumber())
                .totalLoanAmount(loans.getTotalLoanAmount())
                .paidAmount(loans.getPaidAmount())
                .outstandingAmount(loans.getOutstandingAmount())
                .build();
        return loanDto;
    }
}
