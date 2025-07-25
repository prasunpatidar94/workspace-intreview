package com.sun.accounts.service.impl;

import com.sun.accounts.constant.AccountsConstants;
import com.sun.accounts.dto.AccountsDto;
import com.sun.accounts.dto.CustomerDto;
import com.sun.accounts.entity.Accounts;
import com.sun.accounts.entity.Customer;
import com.sun.accounts.exception.CustomerAlreadyExistsException;
import com.sun.accounts.exception.ResourceNotFoundException;
import com.sun.accounts.mapper.AccountsMapper;
import com.sun.accounts.mapper.CustomerMapper;
import com.sun.accounts.repository.AccountsRepository;
import com.sun.accounts.repository.CustomerRepository;
import com.sun.accounts.service.IAccountServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements IAccountServices {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    private static long createNewAccountNumber() {
        return 1000000000L + new Random().nextInt(900000000);
    }

    /**
     * @param customerDto
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Optional<Customer> optionalsCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (!optionalsCustomer.isPresent()) {
            Customer customer = CustomerMapper.mapCustomerDtoEntityToCustomer(customerDto, new Customer());
            Customer customerSaved = customerRepository.save(customer);
            accountsRepository.save(createNewAccount(customerSaved));
        } else {
            throw new CustomerAlreadyExistsException("Customer Already Exists with given mobile number : " + optionalsCustomer.get().getMobileNumber());

        }

    }

    /**
     * @param customer
     * @return
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        newAccount.setAccountNumber(createNewAccountNumber());
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }

    /**
     * @param mobileNumber
     * @return
     */
    @Override
    public CustomerDto fetchByMobileNumber(String mobileNumber) {

        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Accounts", "customerId", customer.getCustomerId().toString()));
        CustomerDto customerDto = CustomerMapper.mapCustomerEntityToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapAccountEntityToAccountDto(accounts, new AccountsDto()));
        return customerDto;
    }

    /**
     * @param customerDto
     * @return
     */
    @Override
    public boolean updateAccounts(CustomerDto customerDto) {
        boolean isUpdate = false;
        AccountsDto accountsDto = customerDto.getAccountsDto();
        if (accountsDto != null) {
            //Check
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "accountNumber", accountsDto.getAccountNumber().toString())
            );
            accounts = accountsRepository.save(AccountsMapper.mapAccountDtoEntityToAccount(accountsDto, accounts));
            Long customerId = accounts.getCustomerId();
            //Check
            Customer customer = customerRepository.findById(accounts.getCustomerId()).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "customerId", customerId.toString())
            );

            customerRepository.save(CustomerMapper.mapCustomerDtoEntityToCustomer(customerDto, customer));
            isUpdate = true;
        }
        return isUpdate;
    }

    /**
     * @param mobileNumber
     * @return
     */
    @Override
    public boolean deleteAccounts(String mobileNumber) {

        boolean isDeleted= false;
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("Customer" , "mobileNumber",mobileNumber)
        );
        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        isDeleted=true;
        return isDeleted;
    }
}
