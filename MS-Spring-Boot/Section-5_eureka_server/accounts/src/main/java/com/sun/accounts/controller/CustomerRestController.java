package com.sun.accounts.controller;

import com.sun.accounts.constant.AccountsConstants;
import com.sun.accounts.dto.*;
import com.sun.accounts.service.IAccountServices;
import com.sun.accounts.service.ICustomerServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customer/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@Tag(name = " Rest API Services for customer in SunBank", description = "This customer rest microservice is responsible for UPDATE,DELETE,GET,POST services with respective ACCOUNTS ")
public class CustomerRestController {


    private final ICustomerServices iCustomerServices;

    //
//
//    @Autowired  // optional is one constructor we are using
    public CustomerRestController(ICustomerServices iCustomerServices) {
        this.iCustomerServices = iCustomerServices;
    }


    @Operation(summary = "Fetch Account Rest API", description = "Rest API to fetch customer details using mobile number from SunBank")
    @ApiResponse(responseCode = AccountsConstants.STATUS_200, description = AccountsConstants.MESSAGE_200)
    @GetMapping("/fetch/customer/details")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerByMobileNumber(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits ...!") String mobileNumber) {
        CustomerDetailsDto customerDetailsDto = iCustomerServices.fetchCustomerByMobileNumber(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDetailsDto);
    }

}
