package com.sun.accounts.controller;

import com.sun.accounts.constant.AccountsConstants;
import com.sun.accounts.dto.CustomerDto;
import com.sun.accounts.dto.ResponseDto;
import com.sun.accounts.service.IAccountServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsRestController {

    private IAccountServices iAccountServices;

    @GetMapping("/acct")
    public String acctHealth() {
        return "I am, account controller...!";
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        iAccountServices.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }


    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchByMobileNumber(@RequestParam String mobileNumber) {

        CustomerDto customerDto = iAccountServices.fetchByMobileNumber(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccounts(@RequestBody CustomerDto customerDto) {

        return (iAccountServices.updateAccounts(customerDto)) ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200)) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
    }

}
