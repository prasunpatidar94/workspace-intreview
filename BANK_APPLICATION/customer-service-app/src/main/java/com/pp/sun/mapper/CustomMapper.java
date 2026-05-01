package com.pp.sun.mapper;

import com.pp.sun.dto.CustomerRequest;
import com.pp.sun.repository.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomMapper {
    CustomerEntity toEntity(CustomerRequest customerRequest) {
        return CustomerEntity.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .middleName(customerRequest.getMiddleName())
                .mobileNumber(customerRequest.getMobileNumber())
                .address(customerRequest.getAddress())
                .externalId(customerRequest.getExternalId())
                .build();
    }
}
