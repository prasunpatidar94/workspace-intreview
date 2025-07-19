package com.sun.loans.service;

import com.sun.loans.dto.LoanDto;

public interface ILoansServices {

    void createLoan(LoanDto loanDto);
    LoanDto fetchLoan(String mobileNumber);
    boolean updateLoan(LoanDto mobileNumber);
}
