package com.sun.accounts.controller;

import com.sun.accounts.constant.AccountsConstants;
import com.sun.accounts.dto.AccountContactInfoDetailsDto;
import com.sun.accounts.dto.CustomerDto;
import com.sun.accounts.dto.ErrorResponseDto;
import com.sun.accounts.dto.ResponseDto;
import com.sun.accounts.service.IAccountServices;
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
@RequestMapping(path = "/account/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@Tag(name = "CURD Rest Services for Account in SunBank", description = "This account rest microservice is responsible for UPDATE,DELETE,GET,POST services with respective ACCOUNTS ")
public class AccountsRestController {


    private final IAccountServices iAccountServices;
    // @Autowired
    private final Environment environment;
    private final AccountContactInfoDetailsDto accountContactInfoDetailsDto;
    @Value("${build.version}")
    private String buildVersion;


    @Autowired  // optional is one constructor we are using
    public AccountsRestController(IAccountServices iAccountServices, Environment environment, AccountContactInfoDetailsDto accountContactInfoDetailsDto) {
        this.iAccountServices = iAccountServices;
        this.environment = environment;
        this.accountContactInfoDetailsDto = accountContactInfoDetailsDto;

    }


    @Operation(summary = "Account Service Health Checker", description = "Rest Service to support to check  health for Account Microservices")
    @ApiResponse(responseCode = "200", description = "Healthy")
    @GetMapping("/acct")
    public String acctHealth() {
        return "Account's MicroService Good...!   -  App version is : " + buildVersion + "   Java-version : " + environment.getProperty("java.version");
    }

    @Operation(summary = "Create Account Rest API", description = "Rest API to create account and customer in SunBank")
    @ApiResponse(responseCode = AccountsConstants.STATUS_201, description = AccountsConstants.MESSAGE_201)
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        iAccountServices.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @Operation(summary = "Fetch Account Rest API", description = "Rest API to fetch account details using mobile number from SunBank")
    @ApiResponse(responseCode = AccountsConstants.STATUS_200, description = AccountsConstants.MESSAGE_200)
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchByMobileNumber(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits ...!") String mobileNumber) {
        CustomerDto customerDto = iAccountServices.fetchByMobileNumber(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @Operation(summary = "Update Account Rest API", description = "Rest API to Update account details inside SunBank")
    @ApiResponses({@ApiResponse(responseCode = AccountsConstants.STATUS_200, description = AccountsConstants.MESSAGE_200), @ApiResponse(responseCode = AccountsConstants.STATUS_417, description = AccountsConstants.MESSAGE_417_UPDATE), @ApiResponse(responseCode = AccountsConstants.STATUS_500, description = AccountsConstants.MESSAGE_500)})
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccounts(@Valid @RequestBody CustomerDto customerDto) {
        return (iAccountServices.updateAccounts(customerDto)) ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200)) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
    }

    @Operation(summary = "Delete Account Rest API", description = "Rest API to Delete account details inside SunBank")
    @ApiResponses({@ApiResponse(responseCode = AccountsConstants.STATUS_200, description = AccountsConstants.MESSAGE_200), @ApiResponse(responseCode = AccountsConstants.STATUS_417, description = AccountsConstants.MESSAGE_417_DELETE), @ApiResponse(responseCode = AccountsConstants.STATUS_500, description = AccountsConstants.MESSAGE_500, content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))})
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits ...!") String mobileNumber) {
        return (iAccountServices.deleteAccounts(mobileNumber)) ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200)) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
    }

    @GetMapping("contact-info")
    public ResponseEntity<AccountContactInfoDetailsDto> getiAccountServices() {

        return ResponseEntity.status(HttpStatus.OK).body(accountContactInfoDetailsDto);
    }
}
