package com.sun.accounts.service.impl;

import com.sun.accounts.constant.AccountsConstants;
import com.sun.accounts.dto.AccountsDto;
import com.sun.accounts.dto.CustomerDetailsDto;
import com.sun.accounts.dto.CustomerDto;
import com.sun.accounts.dto.client.CardsDto;
import com.sun.accounts.dto.client.LoanDto;
import com.sun.accounts.entity.Accounts;
import com.sun.accounts.entity.Customer;
import com.sun.accounts.exception.CustomerAlreadyExistsException;
import com.sun.accounts.exception.ResourceNotFoundException;
import com.sun.accounts.mapper.AccountsMapper;
import com.sun.accounts.mapper.CustomerMapper;
import com.sun.accounts.repository.AccountsRepository;
import com.sun.accounts.repository.CustomerRepository;
import com.sun.accounts.service.IAccountServices;
import com.sun.accounts.service.ICustomerServices;
import com.sun.accounts.service.client.CardsFeignClient;
import com.sun.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements ICustomerServices {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;


    @Override
    public CustomerDetailsDto fetchCustomerByMobileNumber(String mobileNumber) {

        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Accounts", "customerId", customer.getCustomerId().toString()));
        CustomerDto customerDto = CustomerMapper.mapCustomerEntityToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapAccountEntityToAccountDto(accounts, new AccountsDto()));

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapCustomerToCustomerDetailsDto(customerDto, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapAccountEntityToAccountDto(accounts, new AccountsDto()));

        ResponseEntity<LoanDto> loanDtoResponseEntity= loansFeignClient.fetchByMobileOrLoanNumber(mobileNumber,"MOB");
        customerDetailsDto.setLoansDto(loanDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity= cardsFeignClient.fetchByMobileOrCardNumber(mobileNumber,"MOB");
        customerDetailsDto.setCardDto(cardsDtoResponseEntity.getBody());


        return customerDetailsDto;
    }

}
