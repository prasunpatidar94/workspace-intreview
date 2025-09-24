package com.sun.accounts.mapper;


import com.sun.accounts.dto.CustomerDetailsDto;
import com.sun.accounts.dto.CustomerDto;
import com.sun.accounts.entity.Customer;

public class CustomerMapper {
    /**
     * @param customer
     * @param customerDto
     * @return CustomerDto
     */
    public static CustomerDto mapCustomerEntityToCustomerDto(Customer customer, CustomerDto customerDto) {


        customerDto .setEmail(customer.getEmail());
        customerDto .setName(customer.getName());
        customerDto .setMobileNumber(customer.getMobileNumber());;

        return customerDto;
    }


    public static CustomerDetailsDto mapCustomerToCustomerDetailsDto(CustomerDto customerDto , CustomerDetailsDto customerDetailsDto) {


        customerDetailsDto .setEmail(customerDto.getEmail());
        customerDetailsDto .setName(customerDto.getName());
        customerDetailsDto .setMobileNumber(customerDto.getMobileNumber());;


        return customerDetailsDto;
    }

    /**
     * @param customerDto
     * @param customer
     * @return Customer
     */
    public static Customer mapCustomerDtoEntityToCustomer(CustomerDto customerDto, Customer customer) {

        customer.setEmail(customerDto.getEmail());
        customer.setName(customerDto.getName());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}
