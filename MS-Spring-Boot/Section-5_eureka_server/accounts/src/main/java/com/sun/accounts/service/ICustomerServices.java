package com.sun.accounts.service;

import com.sun.accounts.dto.CustomerDetailsDto;
import com.sun.accounts.dto.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public interface ICustomerServices {

    /**
     * 
     * @param mobileNumber
     * @return
     */
    CustomerDetailsDto fetchCustomerByMobileNumber(String mobileNumber);

}
