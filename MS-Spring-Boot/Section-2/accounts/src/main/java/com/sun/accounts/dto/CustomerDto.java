package com.sun.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "Name can not be empty ...! ")
    @Size(min = 5, max = 30, message = "The length of name should be between5 to 30 char ...!")
    private String name;

    @NotEmpty(message = "Email address can not be empty ...! ")
    @Email(message = "Email Address should be contain valid value ...!")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit with valid value ..!")
    private String mobileNumber;

    private AccountsDto accountsDto;

}
