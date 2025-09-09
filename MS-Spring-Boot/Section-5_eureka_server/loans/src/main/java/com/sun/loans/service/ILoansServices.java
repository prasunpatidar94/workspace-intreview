package com.sun.loans.service;

import com.sun.loans.dto.LoanDto;
import com.sun.loans.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ILoansServices {

    void createLoan(LoanDto loanDto);
    boolean updateLoan(LoanDto loanDto);

    LoanDto fetchByMobileOrLoanNumber( String findByValue, String findBy);

    boolean deleteByMobileOrLoanNumber(String findByValue, String findBy);
}
