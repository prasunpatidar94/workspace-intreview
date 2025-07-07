package com.sun.accounts.service;

import com.sun.accounts.dto.AccountsDto;
import com.sun.accounts.dto.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public interface IAccountServices {

    /**
     *
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchByMobileNumber(String mobileNumber);

    boolean updateAccounts(CustomerDto customerDto);
}
