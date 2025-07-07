package com.sun.accounts.mapper;

import com.sun.accounts.dto.AccountsDto;
import com.sun.accounts.entity.Accounts;

public class AccountsMapper {
    /**
     *
     * @param accounts
     * @param accountsDto
     * @return AccountsDto
     */
    public static AccountsDto mapAccountEntityToAccountDto(Accounts accounts, AccountsDto accountsDto) {


        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());

        return accountsDto;
    }

    /**
     *
     * @param accountsDto
     * @param accounts
     * @return Accounts
     */
    public static Accounts mapAccountDtoEntityToAccount(AccountsDto accountsDto, Accounts accounts) {

        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
