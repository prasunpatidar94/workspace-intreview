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

    /**
     *
     * @param mobileNumber
     * @return
     */
    CustomerDto fetchByMobileNumber(String mobileNumber);

    /**
     *
     * @param customerDto
     * @return
     */
    boolean updateAccounts(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber
     * @return
     */
    boolean deleteAccounts(String mobileNumber);
}
