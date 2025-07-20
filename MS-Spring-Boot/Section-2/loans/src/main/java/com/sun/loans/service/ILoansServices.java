package com.sun.loans.service;

import com.sun.loans.dto.LoanDto;
import org.springframework.stereotype.Service;

@Service
public interface ILoansServices {

    void createLoan(LoanDto loanDto);
    LoanDto updateLoan(LoanDto loanDto);

    LoanDto fetchByMobileOrLoanNumber( String findByValue, String findBy);
}
