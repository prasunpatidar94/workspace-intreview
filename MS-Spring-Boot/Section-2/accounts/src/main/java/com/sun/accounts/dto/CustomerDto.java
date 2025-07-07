package com.sun.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CustomerDto {

    private String name;
    private String email;
    private String mobileNumber;
    private AccountsDto accountsDto;

}
