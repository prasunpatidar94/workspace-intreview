package com.pp.sun.service;

import com.pp.sun.dto.CustomerCreatedResponse;
import com.pp.sun.dto.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public interface CustomerServices {
    CustomerCreatedResponse createCustomer(CustomerRequest customerRequest);
}
