package com.sun.loans.controller;

import com.sun.loans.dto.LoanDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/loans/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoansRestController {

    @GetMapping("/loans")
    public String health(){
        return "OK";
    }

    @PostMapping("/create")
    public ResponseEntity<LoanDto> create(@RequestBody LoanDto loanDto ){


        ResponseEntity.status(HttpStatus.CREATED).body(loanDto);

    }

}
