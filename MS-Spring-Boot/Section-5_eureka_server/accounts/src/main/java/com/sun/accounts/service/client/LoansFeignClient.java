package com.sun.accounts.service.client;

import com.sun.accounts.dto.client.CardsDto;
import com.sun.accounts.dto.client.LoanDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("loans")
public interface LoansFeignClient {

    @GetMapping(value = "/loans/api/fetch" , consumes = "application/json")
    ResponseEntity<LoanDto> fetchByMobileOrLoanNumber(@RequestParam String findByValue, @RequestParam String findBy) ;

    }
