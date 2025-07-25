package com.sun.loans.service.impl;

import com.sun.loans.dto.LoanDto;
import com.sun.loans.entity.Loan;
import com.sun.loans.exception.InvalidArgumentPassedException;
import com.sun.loans.exception.ResourceAlreadyExistsException;
import com.sun.loans.exception.ResourceNotFoundException;
import com.sun.loans.mapper.LoanMapper;
import com.sun.loans.repository.LoanRepository;
import com.sun.loans.service.ILoansServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@AllArgsConstructor
@Service
public class LoansServicesImpl implements ILoansServices {
    private LoanRepository loanRepository;


    @Override
    public void createLoan(LoanDto loanDto) {

        if (loanRepository.findByMobileNumber(loanDto.getMobileNumber()).isPresent()) {
            throw new ResourceAlreadyExistsException("Loan already registered with given mobileNumber " + loanDto.getMobileNumber());
        }
        loanRepository.save(createNewLoan(loanDto));
    }

    @Override
    public boolean updateLoan(LoanDto loanDto) {
        Optional<Loan> loanOptional = loanRepository.findByLoanNumber(loanDto.getLoanNumber());
        Loan loan = loanOptional.orElseThrow(() -> new ResourceNotFoundException("Loan", "loanNumber", loanDto.getLoanNumber()));
        loanRepository.save(LoanMapper.mapLoadDtoToLoan(loanDto, loan));
        return true;
    }

    @Override
    public LoanDto fetchByMobileOrLoanNumber(String findByValue, String findBy) {

        LoanDto loanDto = null;
        if (findBy.equalsIgnoreCase("MOB")) {
            loanDto = LoanMapper.mapLoadToLoanDto(
                    loanRepository.findByMobileNumber(findByValue).orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", findByValue)), new LoanDto()
            );
        } else if (findBy.equalsIgnoreCase("LN")) {
            loanDto = LoanMapper.mapLoadToLoanDto(
                    loanRepository.findByLoanNumber(findByValue).orElseThrow(() -> new ResourceNotFoundException("Loan", "loanNumber", findByValue))
                    , new LoanDto());
        } else {
            throw new InvalidArgumentPassedException("Loan", "mobileNumber/loanNumber", findByValue);
        }

        return loanDto;
    }

    @Override
    public boolean deleteByMobileOrLoanNumber(String findByValue, String findBy) {
        boolean isDeleted = false;
        if (findBy.equalsIgnoreCase("MOB")) {
            loanRepository.findByMobileNumber(findByValue).orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", findByValue));
            loanRepository.deleteByMobileNumber(findByValue);
            isDeleted= true;

        } else if (findBy.equalsIgnoreCase("LN")) {
            loanRepository.findByLoanNumber(findByValue).orElseThrow(() -> new ResourceNotFoundException("Loan", "loanNumber", findByValue));
            loanRepository.deleteByMobileNumber(findByValue);
            isDeleted= true;
        } else {
            throw new InvalidArgumentPassedException("Loan", "mobileNumber/loanNumber", findByValue);
        }
        return isDeleted;
    }

    private Loan createNewLoan(LoanDto loanDto) {
        Loan loan = LoanMapper.mapLoadDtoToLoan(loanDto, new Loan());
        loan.setLoanNumber(createLoanNumber());
        return loan;
    }

    private String createLoanNumber() {
        return Long.toString(100000000000L + new Random().nextInt(900000000));
    }


}
