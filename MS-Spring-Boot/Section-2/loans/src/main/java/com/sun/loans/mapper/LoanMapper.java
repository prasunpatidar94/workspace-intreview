package com.sun.loans.mapper;

import com.sun.loans.dto.LoanDto;
import com.sun.loans.entity.Loan;

public class LoanMapper {
    public  static Loan mapLoadDtoToLoan(LoanDto loanDto, Loan loan) {

        loan.setMobileNumber(loanDto.getMobileNumber());
        loan.setLoanNumber(loanDto.getLoanNumber());
        loan.setLoanType(loanDto.getLoanType());
        loan.setTotalLoanAmount(loanDto.getTotalLoanAmount());
        loan.setPaidAmount(loanDto.getPaidAmount());
        loan.setOutstandingAmount(loanDto.getOutstandingAmount());

        return loan;
    }
    public static LoanDto mapLoadToLoanDto(Loan loan, LoanDto loanDto) {

        loanDto = new LoanDto.Builder()
                .loanType(loan.getLoanType())
                .mobileNumber(loan.getMobileNumber())
                .loanNumber(loan.getLoanNumber())
                .totalLoanAmount(loan.getTotalLoanAmount())
                .paidAmount(loan.getPaidAmount())
                .outstandingAmount(loan.getOutstandingAmount())
                .build();
        return loanDto;
    }
}
