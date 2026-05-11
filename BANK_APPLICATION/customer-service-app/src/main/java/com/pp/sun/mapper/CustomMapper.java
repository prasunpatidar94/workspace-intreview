package com.pp.sun.mapper;

import com.pp.sun.dto.CustomerCreatedResponse;
import com.pp.sun.dto.CustomerRequest;
import com.pp.sun.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomMapper {
    public  CustomerEntity toEntity(CustomerRequest customerRequest) {
        return CustomerEntity.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .middleName(customerRequest.getMiddleName())
                .mobileNumber(customerRequest.getMobileNumber())
                .address(customerRequest.getAddress())
                .externalId(customerRequest.getExternalId())
                .build();
    }
    public CustomerCreatedResponse  toCustomerCreatedResponse (CustomerEntity customerEntity){
        return CustomerCreatedResponse.builder()
                .createdTs(customerEntity.getCreatedTs())
                .externalId(customerEntity.getExternalId())
                .version(customerEntity.getVersion())
                .kycStatus(customerEntity.getKycStatus())
                .build();
    }
}

