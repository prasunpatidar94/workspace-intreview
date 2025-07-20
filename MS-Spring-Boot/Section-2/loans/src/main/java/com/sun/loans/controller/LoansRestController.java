package com.sun.loans.controller;

import com.sun.loans.constant.LoansConstants;
import com.sun.loans.dto.LoanDto;
import com.sun.loans.dto.ResponseDto;
import com.sun.loans.service.ILoansServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/loans/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class LoansRestController {

    private ILoansServices iLoansServices;

    @GetMapping("/loans")
    public String health() {
        return "OK";
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create(@RequestBody LoanDto loanDto) {

        iLoansServices.createLoan(loanDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ResponseDto.builder()
                        .StatusCode(LoansConstants.STATUS_201)
                        .StatusSms(LoansConstants.MESSAGE_201)
                        .build()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> update(@RequestBody LoanDto loanDto) {

        iLoansServices.updateLoan(loanDto);
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseDto.builder()
                        .StatusCode(LoansConstants.STATUS_201)
                        .StatusSms(LoansConstants.MESSAGE_201)
                        .build()
        );
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoanDto> fetchByMobileOrLoanNumber(@RequestParam String findByValue, @RequestParam String findBy) {
        return ResponseEntity.status(HttpStatus.OK).body(iLoansServices.fetchByMobileOrLoanNumber(findByValue, findBy));
    }


}
