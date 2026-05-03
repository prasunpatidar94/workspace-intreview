package com.pp.sun.service;

import com.pp.sun.dto.CustomerCreatedResponse;
import com.pp.sun.dto.CustomerRequest;
import com.pp.sun.entity.CustomerEntity;
import com.pp.sun.entity.KycStatus;
import com.pp.sun.mapper.CustomMapper;
import com.pp.sun.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CustomerServicesImpl implements CustomerServices  {

    private  CustomMapper customMapper ;
    private CustomerRepository customerRepository;

    @Override
    public CustomerCreatedResponse createCustomer(CustomerRequest customerRequest) {
        CustomerEntity customerEntity = customMapper.toEntity(customerRequest);
        customerEntity.setKycStatus(KycStatus.PENDING);
        customerEntity.setActive(false);
        customerEntity.setRequestFingerprint("abc");
        if(customerRequest.getExternalId())
        return null;
    }
}
