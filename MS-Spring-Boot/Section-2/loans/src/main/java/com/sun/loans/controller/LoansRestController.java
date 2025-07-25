package com.sun.loans.controller;

import com.sun.loans.constant.LoansConstants;
import com.sun.loans.dto.ErrorResponseDto;
import com.sun.loans.dto.LoanDto;
import com.sun.loans.dto.ResponseDto;
import com.sun.loans.service.ILoansServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/loans/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Tag(name = "Loan Microservice - (SunBank)", description = "Rest api for Loan microservice with all CURD operations ")
public class LoansRestController {

    private ILoansServices iLoansServices;

    @Operation(summary = "Loan Service Health Checker", description = "Rest Service to support to check  health for Loan Microservices")
    @ApiResponse(responseCode = "200", description = "Healthy")
    @GetMapping("/loans")
    public String health() {
        return "Healthy";
    }

    @Operation(summary = "Create Account Rest API", description = "Rest API to create account and customer in SunBank")
    @ApiResponse(responseCode = LoansConstants.STATUS_201, description = LoansConstants.MESSAGE_201)
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

    @Operation(summary = "Update Account Rest API", description = "Rest API to Update account details inside SunBank")
    @ApiResponses({@ApiResponse(responseCode = LoansConstants.STATUS_200, description = LoansConstants.MESSAGE_200),@ApiResponse(responseCode = LoansConstants.STATUS_417, description = LoansConstants.MESSAGE_417_UPDATE), @ApiResponse(responseCode = LoansConstants.STATUS_500, description = LoansConstants.MESSAGE_500)})

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> update(@RequestBody LoanDto loanDto) {

        return (iLoansServices.updateLoan(loanDto)) ?
                ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_UPDATE));
    }

    @Operation(summary = "Fetch Account Rest API", description = "Rest API to fetch account details using mobile number from SunBank")
    @ApiResponse(responseCode = LoansConstants.STATUS_200, description = LoansConstants.MESSAGE_200)
    @GetMapping("/fetch")
    public ResponseEntity<LoanDto> fetchByMobileOrLoanNumber(@RequestParam String findByValue, @RequestParam String findBy) {
        return ResponseEntity.status(HttpStatus.OK).body(iLoansServices.fetchByMobileOrLoanNumber(findByValue, findBy));
    }

    @Operation(summary = "Delete Account Rest API", description = "Rest API to Delete account details inside SunBank")
    @ApiResponses({@ApiResponse(responseCode = LoansConstants.STATUS_200, description = LoansConstants.MESSAGE_200),@ApiResponse(responseCode = LoansConstants.STATUS_417, description = LoansConstants.MESSAGE_417_DELETE), @ApiResponse(responseCode = LoansConstants.STATUS_500, description = LoansConstants.MESSAGE_500, content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))})
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteByMobileOrLoanNumber(@RequestParam String findByValue, @RequestParam String findBy) {
        return (iLoansServices.deleteByMobileOrLoanNumber(findByValue, findBy)) ?
                ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_DELETE));
    }


}
